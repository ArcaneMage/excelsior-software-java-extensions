package org.javalaboratories.core.tuple;


import org.javalaboratories.core.Maybe;
import org.javalaboratories.core.function.Consumer4;
import org.javalaboratories.core.function.Function4;

import java.util.Objects;
import java.util.function.Function;

import static org.javalaboratories.core.tuple.Tuple.of;

/**
 * A tuple with depth of 4
 *
 * @param <T1> type of 1st element
 * @param <T2> type of 2nd element
 * @param <T3> type of 3rd element
 * @param <T4> type of 4th element
 *
 * @author Kevin Henry
 */
public final class Tuple4<T1,T2,T3,T4> extends AbstractTuple {
    private final T1 t1;
    private final T2 t2;
    private final T3 t3;
    private final T4 t4;

    public Tuple4(T1 t1, T2 t2, T3 t3, T4 t4) {
        super(t1,t2,t3,t4);
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
    }

    /**
     * Converts iterable into a tuple, if possible.
     * <p>
     * Creates a tuple to a depth of 4 from iterable object. If there is
     * insufficient elements, then {@link Maybe} will be empty.
     *
     * @param iterable Iterable object
     * @param <T> iterable type.
     * @return A tuple in {@link Maybe} object container.
     */
    public static <T> Maybe<Tuple4<T,T,T,T>> fromIterable(Iterable<T> iterable) {
        return Tuples.fromIterable(iterable, 4);
    }

    public T1 value1() {
        return t1;
    }

    public T2 value2() {
        return t2;
    }

    public T3 value3() {
        return t3;
    }

    public T4 value4() {
        return t4;
    }

    /**
     * Add value at position 1
     */
    public <T> Tuple5<T,T1,T2,T3,T4> addAt1(T value) {
        return add(1,value);
    }

    /**
     * Add value at position 2
     */
    public <T> Tuple5<T1,T,T2,T3,T4> addAt2(T value) {
        return add(2,value);
    }

    /**
     * Add value at position 3
     */
    public <T> Tuple5<T1,T2,T,T3,T4> addAt3(T value) {
        return add(3,value);
    }

    /**
     * Add value at position 4
     */
    public <T> Tuple5<T1,T2,T3,T,T4> addAt4(T value) {
        return add(4,value);
    }

    /**
     * Hop to position/value 1
     */
    public Tuple4<T1,T2,T3,T4> hopTo1() {
        return hop(1);
    }

    /**
     * Hop to position/value 2
     */
    public Tuple3<T2,T3,T4> hopTo2() {
        return hop(2);
    }

    /**
     * Hop to position/value 3
     */
    public Tuple2<T3,T4> hopTo3() {
        return hop(3);
    }

    /**
     * Hop to position/value 4
     */
    public Tuple1<T4> hopTo4() {
        return hop(4);
    }

    /**
     * Joins a tuple to this tuple.
     * @param value a tuple object.
     */
    public <T> Tuple5<T1,T2,T3,T4,T> join(T value) {
        return join(of(value));
    }

    /**
     * Joins a value to the end of this tuple.
     */
    public Tuple4<T1,T2,T3,T4> join(Tuple0 value) {
        return super.join(value);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T5> Tuple5<T1,T2,T3,T4,T5> join(Tuple1<T5> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T5,T6> Tuple6<T1,T2,T3,T4,T5,T6> join(Tuple2<T5,T6> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T5,T6,T7> Tuple7<T1,T2,T3,T4,T5,T6,T7> join(Tuple3<T5,T6,T7> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T5,T6,T7,T8> Tuple8<T1,T2,T3,T4,T5,T6,T7,T8> join(Tuple4<T5,T6,T7,T8> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T5,T6,T7,T8,T9> Tuple9<T1,T2,T3,T4,T5,T6,T7,T8,T9> join(Tuple5<T5,T6,T7,T8,T9> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T5,T6,T7,T8,T9,T10> Tuple10<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10> join(Tuple6<T5,T6,T7,T8,T9,T10> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T5,T6,T7,T8,T9,T10,T11> Tuple11<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11> join(Tuple7<T5,T6,T7,T8,T9,T10,T11> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T5,T6,T7,T8,T9,T10,T11,T12> Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> join(Tuple8<T5,T6,T7,T8,T9,T10,T11,T12> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T5,T6,T7,T8,T9,T10,T11,T12,T13> Tuple13<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13> join(Tuple9<T5,T6,T7,T8,T9,T10,T11,T12,T13> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> join(Tuple10<T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> join(Tuple11<T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> join(Tuple12<T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> tuple) {
        return super.join(tuple);
    }

    /**
     * Splices at positions 1
     */
    public Tuple2<Tuple0,Tuple4<T1,T2,T3,T4>> spliceAt1() {
        return splice(1);
    }

    /**
     * Splices at positions 2
     */
    public Tuple2<Tuple1<T1>,Tuple3<T2,T3,T4>> spliceAt2() {
        return splice(2);
    }

    /**
     * Splices at positions 3
     */
    public Tuple2<Tuple2<T1,T2>,Tuple2<T3,T4>> spliceAt3() {
        return splice(3);
    }

    /**
     * Splices at positions 4
     */
    public Tuple2<Tuple3<T1,T2,T3>,Tuple1<T4>> spliceAt4() {
        return splice(4);
    }

    /**
     * Transform this tuple into another object
     * @param function function that performs the transformation
     * @param <R> return type of transformation
     * @return transformed object.
     */
    public <R> R map(Function4<? super T1,? super T2,? super T3,? super T4,? extends R> function) {
        return function.apply(t1,t2,t3,t4);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple4<R,T2,T3,T4> mapAt1(Function<? super T1,? extends R> function) {
        return new Tuple4<>(function.apply(t1),t2,t3,t4);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple4<T1,R,T3,T4> mapAt2(Function<? super T2,? extends R> function) {
        return new Tuple4<>(t1,function.apply(t2),t3,t4);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple4<T1,T2,R,T4> mapAt3(Function<? super T3,? extends R> function) {
        return new Tuple4<>(t1,t2,function.apply(t3),t4);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple4<T1,T2,T3,R> mapAt4(Function<? super T4,? extends R> function) {
        return new Tuple4<>(t1,t2,t3,function.apply(t4));
    }

    /**
     * Tests whether given {@code tuple} is equal to this {@code tuple}, and if
     * true, the {@code consumer} function is executed.
     * <p>
     * This is particularly useful if the tuple contents are unknown and all
     * discovered, the {@code consumer} function is performed.
     * <pre>
     * {@code
     *      tuple
     *        .match(all("John","Wellington"), (a,b,c,d) -> System.out.println(a))
     *        .match(all("Alex","Wall",23), (a,b,c,d) -> System.out.println(b))
     * }
     * </pre>
     * @param matcher object to use with this tuple.
     * @param consumer function to execute if match is found.
     * @param <Q> type of matcher.
     * @return this tuple -- useful for multiple matches.
     */
    public <Q extends Matcher> Tuple4<T1,T2,T3,T4> match(final Q matcher, final Consumer4<? super T1,? super T2,? super T3,? super T4> consumer) {
        Objects.requireNonNull(consumer);
        Tuple4<T1,T2,T3,T4> result = this;
        if (matcher.match(this))
            consumer.accept(t1,t2,t3,t4);

        return result;
    }

    /**
     * Remove element at position 1
     */
    public Tuple3<T2,T3,T4> removeAt1() {
        return remove(1);
    }

    /**
     * Remove element at position 2
     */
    public Tuple3<T1,T3,T4> removeAt2() {
        return remove(2);
    }

    /**
     * Remove element at position 3
     */
    public Tuple3<T1,T2,T4> removeAt3() {
        return remove(3);
    }

    /**
     * Remove element at position 4
     */
    public Tuple3<T1,T2,T3> removeAt4() {
        return remove(4);
    }

    /**
     * Rotates this tuple 1 times to the right
     */
    public Tuple4<T4,T1,T2,T3> rotateRight1() {
        return rotateRight(1);
    }

    /**
     * Rotates this tuple 2 times to the right
     */
    public Tuple4<T3,T4,T1,T2> rotateRight2() {
        return rotateRight(2);
    }

    /**
     * Rotates this tuple 3 times to the right
     */
    public Tuple4<T2,T3,T4,T1> rotateRight3() {
        return rotateRight(3);
    }

    /**
     * Rotates this tuple 1 time to the left
     */
    public Tuple4<T2,T3,T4,T1> rotateLeft1() {
        return rotateLeft(1);
    }

    /**
     * Rotates this tuple 2 times to the left
     */
    public Tuple4<T3,T4,T1,T2> rotateLeft2() {
        return rotateLeft(2);
    }

    /**
     * Rotates this tuple 3 times to the left
     */
    public Tuple4<T4,T1,T2,T3> rotateLeft3() {
        return rotateLeft(3);
    }

    /**
     * Truncates tuples at position 1
     */
    public Tuple0 truncateAt1() {
        return truncate(1);
    }

    /**
     * Truncates tuples at position 2
     */
    public Tuple1<T1> truncateAt2() {
        return truncate(2);
    }

    /**
     * Truncates tuples at position 3
     */
    public Tuple2<T1,T2> truncateAt3() {
        return truncate(3);
    }

    /**
     * Truncates tuples at position 4
     */
    public Tuple3<T1,T2,T3> truncateAt4() {
        return truncate(4);
    }
}
