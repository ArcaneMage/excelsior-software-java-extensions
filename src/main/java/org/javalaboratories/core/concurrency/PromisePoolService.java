package org.javalaboratories.core.concurrency;

import org.javalaboratories.core.handlers.Handlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * {@code PromisePoolService} is a custom thread pool executor designed for use
 * with {@link Promise} objects.
 * <p>
 * If required, but rarely necessary, it is possible to provide an alternative
 * thread pool. Achieving this involves configuring the
 * {@code promise-configuration.properties} file, but it is required that the
 * thread pool must inherit from {@link PromisePoolService} class.
 * <p>
 * When the JVM is signalled to shutdown, whether via SIGTERM or through natural
 * program termination, the thread pool will wait for any outstanding running
 * {@code Promise} threads to terminate before concluding. Therefore, it is
 * important that {@code Promise} objects reach to a natural conclusion. It is not
 * advisable for threads to run infinitely. If this is a possibility then it
 * would to be prudent to to force shutdown the pool service with the
 * {@link PromisePoolService#free(long, boolean)} specifying a timeout without
 * retries ahead of program termination.
 * <p>
 * Currently, varies strategies are under consideration to improve shutdown
 * behaviour.
 */
@SuppressWarnings("WeakerAccess")
public class PromisePoolService extends ThreadPoolExecutor {

    private static final Logger logger = LoggerFactory.getLogger(PromisePoolService.class);

    public enum ServiceStates {ACTIVE, CLOSING, INACTIVE}

    public static final long SHUTDOWN_WAIT_TIMEOUT = 5L;

    private static final AtomicInteger workerIndex = new AtomicInteger(0);
    private static final String WORKER_THREAD_NAME="Promise-Worker-%d";

    private final int capacity;
    private final AtomicReference<ServiceStates> state;
    private final Thread shutdownHook;

    /**
     * Constructs an instance of this thread pool.
     * <p>
     * Constructor called from the {@link PromisePoolServiceFactory}, if
     * configured to create an instance of this object.
     * @param capacity Number maximum thread workers to carryout promises.
     */
    public PromisePoolService(final int capacity) {
        super(capacity,capacity,0L,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>(),PromisePoolService::newPromiseWorker);
        this.capacity = capacity;
        this.shutdownHook = new Thread(Handlers.runnable(this::signalTerm));
        this.state = new AtomicReference<>(ServiceStates.ACTIVE);
        Runtime.getRuntime().addShutdownHook(this.shutdownHook);
    }

    /**
     * Returns the current state of this pool service.
     * <p>
     * Indicates whether the thread pool is in an {@link ServiceStates#ACTIVE}
     * state, the normal mode of operation where tasks of {@link Action} objects
     * are accepted for processing. Any other state results in task being
     * rejected and the thread pool actively in the processing of shutting down.
     *
     * @return the current state of the {@link PromisePoolService}
     */
    protected ServiceStates getState() {
        return state.get();
    }

    /**
     * Calling this method starts the shutting down process of the
     * {@link PromisePoolService} thread pool.
     * <p>
     * It will patiently wait for tasks of {@link Action} objects to conclude
     * indefinitely, retrying every {@link PromisePoolService#SHUTDOWN_WAIT_TIMEOUT}.
     * Hence, it is important the threads are not made to run infinitely.
     */
    public final void free() {
        free(SHUTDOWN_WAIT_TIMEOUT,true);
    }

    /**
     * Calling this method starts the shutting down process of the
     * {@link PromisePoolService} thread pool.
     * <p>
     * Use this method to conclude the thread pool ahead of application shutdown.
     * Specify the timeout period and whether the pool should retry after
     * timeouts. If the {@code retry} is {@code false}, then potentially
     * after timeout some threads may still be live, these will interrupted,
     * resulting in unkept promises.
     *
     * @param timeout value in seconds.
     * @param retry if {@code true} indefinitely attempts to terminate threads
     *             after shutdown (use with caution).
     */
    public final void free(final long timeout, final boolean retry) {
        if ( timeout < 1 )
            throw new IllegalArgumentException("Insufficient timeout");
        if ( getState() == ServiceStates.ACTIVE) {
            changeState(ServiceStates.ACTIVE, ServiceStates.CLOSING);
            int i = 0;
            shutdown();
            try {
                while ( !awaitTermination(timeout, TimeUnit.SECONDS) && retry ) {
                    logger.info("Awaiting termination of some promises  -- elapsed {} seconds", ++i * SHUTDOWN_WAIT_TIMEOUT);
                }
                if ( !isTerminated() ) {
                    shutdownNow();
                    logger.debug("Not all promises kept following shutdown -- forced shutdown.");
                }
            } catch (InterruptedException e) {
                logger.error("Termination of capacity (promises) interrupted -- promises not kept");
            } finally {
                changeState(ServiceStates.CLOSING, ServiceStates.INACTIVE);
            }
        }
    }

    /**
     * @return a {@code String} representation of this {@link PromisePoolService} thread pool.
     */
    @Override
    public String toString() {
        return String.format("[capacity=%d,state=%s,shutdownHook=%s]",capacity,state,shutdownHook.getState());
    }

    @SuppressWarnings("StatementWithEmptyBody")
    private void changeState(ServiceStates from, ServiceStates to) {
        // Atomically changes states using low-level
        // CAS strategy (compare-and-swap)
        do {
        } while (!state.compareAndSet(from, to));
    }

    private static Thread newPromiseWorker(final Runnable runnable) {
        String name = String.format(WORKER_THREAD_NAME,workerIndex.incrementAndGet());
        Thread result = new Thread(runnable);
        result.setName(name);
        return result;
    }

    private void signalTerm()  {
        if ( getState() != ServiceStates.ACTIVE ) { // Must be already in the process of termination
            logger.debug("Termination signal received, but ignored -- unnecessary");
            return;
        }
        logger.debug("Termination signal received -- shutting down gracefully");
        try {
            free();
        } finally {
            logger.debug("Termination concluded");
        }
    }
}