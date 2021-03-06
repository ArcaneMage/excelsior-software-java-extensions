package org.javalaboratories.core.util;

import org.javalaboratories.core.Eval;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * This is a container object that holds a value.
 * <p>
 * Generally used in lambda expressions to mutate objects declared as effectively
 * final.
 * <p>
 * @param <T> type writableHolder variable to hold.
 *
 * @deprecated Class is replaced with a pure alternative, namely {@link Eval},
 * which does not have to rely on side-effects. Refer to the {@link Eval
 * #cpeek(Consumer)} and {@link Eval#cpeek(Predicate, Consumer)}  methods for
 * details.
 */
@Deprecated
public interface Holder<T> {

    T get();

    default void set(final T value) {
        throw new UnsupportedOperationException();
    }
}
