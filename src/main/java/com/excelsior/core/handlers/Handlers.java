package com.excelsior.core.handlers;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Objects;
import java.util.function.*;

/**
 * Handlers class provides a comprehensive set of factory methods to handle
 * checked exceptions within lambda expressions.
 * <p>
 * Lambdas are generally short and concise, but checked exceptions can
 * sometimes cause the lambda expression to look unwieldy. This class has many
 * useful methods that compliment common functional interfaces. Each method wraps the
 * function object into a function that transforms the checked exception to a
 * {@link RuntimeException} object.
 * <p>
 * For example, here is an example of a method performing file input/output:
 * <pre>
 *     {@code
 *      public void writeFile(String file) throws IOException {
 *          ...
 *      }
 *
 *      Consumer<String> consumer = s -> {
 *          try {
 *              writeFile(s)
 *          } catch (IOException e) {
 *              ...
 *          }
 *      }
 *
 *      ...becomes...
 *
 *      Consumer<String> consumer = Handlers.consumer(s -> writeFile(s));
 * }
 * </pre>
 */
@SuppressWarnings("WeakerAccess")
public final class Handlers {

    /**
     * Wraps consumer {@link ThrowableConsumer} into a {@link Consumer} function,
     * which handles checked exceptions.
     *
     * @param consumer function that throws a checked exception
     * @param <T> type of input into the operation.
     * @return consumer object that handles the exception.
     */
    public static <T,E extends Throwable> Consumer<T> consumer(ThrowableConsumer<T,E> consumer) {
        Objects.requireNonNull(consumer);
        return t -> {
            try {
                consumer.accept(t);
            } catch (Throwable throwable) {
                handle(throwable);
            }
        };
    }

    /**
     * Wraps biConsumer {@link ThrowableBiConsumer} into a {@link BiConsumer} function,
     * which handles checked exceptions.
     *
     * @param biConsumer function that throws a checked exception.
     * @param <T> type of input into the operation.
     * @param <U> type of input into the operation.
     * @return consumer object that handles the exception.
     */
    public static <T,U,E extends Throwable> BiConsumer<T,U> biConsumer(ThrowableBiConsumer<T,U,E> biConsumer) {
        Objects.requireNonNull(biConsumer);
        return (t,u) -> {
            try {
                biConsumer.accept(t,u);
            } catch (Throwable throwable) {
                handle(throwable);
            }
        };
    }

    /**
     * Wraps function {@link ThrowableFunction} into a {@link Function} function,
     * which handles checked exceptions.
     *
     * @param function function that throws a checked exception.
     * @param <T> type of input into the operation
     * @param <R> type of result from the operation
     * @return function object that handles the exception
     */
    public static <T,R,E extends Throwable> Function<T,R> function(ThrowableFunction<T,R,E> function) {
        Objects.requireNonNull(function);
        return t -> {
            R result = null;
            try {
                result = function.apply(t);
            } catch (Throwable throwable) {
                handle(throwable);
            }
            return result;
        };
    }

    /**
     * Wraps function {@link ThrowableBiFunction} into a {@link BiFunction} function,
     * which handles checked exceptions.
     *
     * @param function function that throws a checked exception.
     * @param <T> type of input into the operation
     * @param <U> type of second input into the operation
     * @param <R> type of result from the operation
     * @return function object that handles the exception
     */
    public static <T,U,R,E extends Throwable> BiFunction<T,U,R> biFunction(ThrowableBiFunction<T,U,R,E> function) {
        Objects.requireNonNull(function);
        return (t,u) -> {
            R result = null;
            try {
                result = function.apply(t,u);
            } catch (Throwable throwable) {
                handle(throwable);
            }
            return result;
        };
    }

    /**
     * Wraps function {@link ThrowablePredicate} into a {@link Predicate} function,
     * which handles checked exceptions.
     *
     * @param predicate function that throws a checked exception.
     * @param <T> type of input into the operation
     * @return predicate object that handles the exception
     */
    public static <T,E extends Throwable> Predicate<T> predicate(ThrowablePredicate<T,E> predicate) {
        Objects.requireNonNull(predicate);
        return t -> {
            boolean result = false;
            try {
                result = predicate.test(t);
            } catch (Throwable throwable) {
                handle(throwable);
            }
            return result;
        };
    }

    /**
     * Wraps function {@link ThrowableBiPredicate} into a {@link BiPredicate} function,
     * which handles checked exceptions.
     *
     * @param predicate function that throws a checked exception.
     * @param <T> type of input into the operation
     * @param <U> type of second inout into the operation
     * @return predicate object that handles the exception
     */
    public static <T,U,E extends Throwable> BiPredicate<T,U> biPredicate(ThrowableBiPredicate<T,U,E> predicate) {
        Objects.requireNonNull(predicate);
        return (t,u) -> {
            boolean result = false;
            try {
                result = predicate.test(t,u);
            } catch (Throwable throwable) {
                handle(throwable);
            }
            return result;
        };
    }

    /**
     * Wraps operator {@link ThrowableUnaryOperator} into a {@link UnaryOperator} function,
     * which handles the checked exceptions.
     *
     * @param unaryOperator function that throws a checked exception.
     * @param <T> type of input into the operation.
     * @return unary operator object that handles the exception.
     */
    public static <T,E extends Throwable> UnaryOperator<T> unaryOperator(ThrowableUnaryOperator<T,E> unaryOperator) {
        Objects.requireNonNull(unaryOperator);
        return t -> {
            T result = null;
            try {
                result = unaryOperator.apply(t);
            } catch (Throwable throwable) {
                handle(throwable);
            }
            return result;
        };
    }

    /**
     * Wraps operator {@link ThrowableBinaryOperator} into a {@link BinaryOperator} function,
     * which handles the checked exceptions.
     *
     * @param binaryOperator function that throws a checked exception.
     * @param <T> type of input into the operation.
     * @return unary operator object that handles the exception.
     */
    public static <T,E extends Throwable> BinaryOperator<T> binaryOperator(ThrowableBinaryOperator<T,E> binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        return (t,u) -> {
            T result = null;
            try {
                result = binaryOperator.apply(t,u);
            } catch (Throwable throwable) {
                handle(throwable);
            }
            return result;
        };
    }

    private static void handle (Throwable t) {
        if ( t instanceof RuntimeException)
            throw (RuntimeException) t;

        if (t instanceof IOException)
            throw new UncheckedIOException((IOException) t);


        if (t instanceof Exception) {
            throw new RuntimeException(t);
        }

        if (t instanceof Error)
            throw new RuntimeException(t);
    }

    private Handlers() {}
}