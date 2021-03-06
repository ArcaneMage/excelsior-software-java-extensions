/*
 * Copyright 2020 Kevin Henry
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.javalaboratories.core;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

@SuppressWarnings("WeakerAccess")
public final class MaybeInt implements Iterable<Integer> {

    private Maybe<Integer> value;

    private static final MaybeInt EMPTY = new MaybeInt();

    public static MaybeInt empty() { return EMPTY; }

    public static MaybeInt of(int value) { return new MaybeInt(value); }

    public static MaybeInt of(Optional<Integer> value) {
        Objects.requireNonNull(value);
        return value.map(MaybeInt::of).orElse(EMPTY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaybeInt that = (MaybeInt) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int getAsInt() { return value.get(); }

    public void ifPresent(Consumer<? super Integer> action) {
        this.value.ifPresent(action);
    }

    public void ifPresentOrElse(Consumer<? super Integer> action, Runnable emptyAction) {
        this.value.ifPresentOrElse(action,emptyAction);
    }

    public boolean isEmpty () { return this.value.isEmpty(); }

    public boolean isPresent() { return this.value.isPresent(); }

    public int orElse(int other) {
        return this.value.orElse(other);
    }

    public int orElseGet(Supplier<? extends Integer> supplier) {
        return this.value.orElseGet(supplier);
    }

    public int orElseThrow() {
        return orElseThrow(NoSuchElementException::new);
    }

    public <E extends Throwable> int orElseThrow(Supplier<? extends E> exceptionSupplier) throws E {
        return this.value.orElseThrow(exceptionSupplier);
    }

    public IntStream stream() {
        return this.value.isPresent() ? IntStream.of(this.value.get()) : IntStream.of();
    }

    public Maybe<Integer> toNullable() {
        return isPresent() ? Maybe.of(this.value.get()) : Maybe.empty();
    }

    public String toString() {
        return this.isPresent() ? String.format("NullableInt[%d]",this.value.get()) : "NullableInt[isEmpty]";
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.value.iterator();
    }

    private MaybeInt() { this.value = Maybe.empty(); }

    private MaybeInt(int value) { this.value = Maybe.ofNullable(value); }

}
