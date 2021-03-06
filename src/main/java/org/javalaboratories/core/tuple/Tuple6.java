package org.javalaboratories.core.tuple;


import org.javalaboratories.core.Maybe;
import org.javalaboratories.core.function.Consumer6;
import org.javalaboratories.core.function.Function6;

import java.util.Objects;
import java.util.function.Function;

import static org.javalaboratories.core.tuple.Tuple.of;

/**
 * A tuple with depth of 6
 *
 * @param <T1> type of 1st element
 * @param <T2> type of 2nd element
 * @param <T3> type of 3rd element
 * @param <T4> type of 4th element
 * @param <T5> type of 5th element
 * @param <T6> type of 6th element
 *
 * @author Kevin Henry
 */
public final class Tuple6<T1,T2,T3,T4,T5,T6> extends AbstractTuple {
    private final T1 t1;
    private final T2 t2;
    private final T3 t3;
    private final T4 t4;
    private final T5 t5;
    private final T6 t6;

    public Tuple6(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        super(t1,t2,t3,t4,t5,t6);
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
        this.t6 = t6;
    }

    /**
     * Converts iterable into a tuple, if possible.
     * <p>
     * Creates a tuple to a depth of 6 from iterable object. If there is
     * insufficient elements, then {@link Maybe} will be empty.
     *
     * @param iterable Iterable object
     * @param <T> iterable type.
     * @return A tuple in {@link Maybe} object container.
     */
    public static <T> Maybe<Tuple6<T,T,T,T,T,T>> fromIterable(Iterable<T> iterable) {
        return Tuples.fromIterable(iterable, 6);
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

    public T5 value5() {
        return t5;
    }

    public T6 value6() {
        return t6;
    }

    /**
     * Add value at position 1
     */
    public <T> Tuple7<T,T1,T2,T3,T4,T5,T6> addAt1(T value) {
        return add(1,value);
    }

    /**
     * Add value at position 2
     */
    public <T> Tuple7<T1,T,T2,T3,T4,T5,T6> addAt2(T value) {
        return add(2,value);
    }

    /**
     * Add value at position 3
     */
    public <T> Tuple7<T1,T2,T,T3,T4,T5,T6> addAt3(T value) {
        return add(3,value);
    }

    /**
     * Add value at position 4
     */
    public <T> Tuple7<T1,T2,T3,T,T4,T5,T6> addAt4(T value) {
        return add(4,value);
    }

    /**
     * Add value at position 5
     */
    public <T> Tuple7<T1,T2,T3,T4,T,T5,T6> addAt5(T value) {
        return add(5,value);
    }

    /**
     * Add value at position 6
     */
    public <T> Tuple7<T1,T2,T3,T4,T5,T,T6> addAt6(T value) {
        return add(6,value);
    }
    
    /**
     * Hop to position/value 1
     */
    public Tuple6<T1,T2,T3,T4,T5,T6> hopTo1() {
        return hop(1);
    }

    /**
     * Hop to position/value 2
     */
    public Tuple5<T2,T3,T4,T5,T6> hopTo2() {
        return hop(2);
    }

    /**
     * Hop to position/value 3
     */
    public Tuple4<T3,T4,T5,T6> hopTo3() {
        return hop(3);
    }

    /**
     * Hop to position/value 4
     */
    public Tuple3<T4,T5,T6> hopTo4() {
        return hop(4);
    }

    /**
     * Hop to position/value 5
     */
    public Tuple2<T5,T6> hopTo5() {
        return hop(5);
    }

    /**
     * Hop to position/value 6
     */
    public Tuple1<T6> hopTo6() {
        return hop(6);
    }

    /**
     * Joins a tuple to this tuple.
     * @param value a tuple object.
     */
    public <T> Tuple7<T1,T2,T3,T4,T5,T6,T> join(T value) {
        return join(of(value));
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public Tuple6<T1,T2,T3,T4,T5,T6> join(Tuple0 tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T7> Tuple7<T1,T2,T3,T4,T5,T6,T7> join(Tuple1<T7> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T7,T8> Tuple8<T1,T2,T3,T4,T5,T6,T7,T8> join(Tuple2<T7,T8> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T7,T8,T9> Tuple9<T1,T2,T3,T4,T5,T6,T7,T8,T9> join(Tuple3<T7,T8,T9> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T7,T8,T9,T10> Tuple10<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10> join(Tuple4<T7,T8,T9,T10> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T7,T8,T9,T10,T11> Tuple11<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11> join(Tuple5<T7,T8,T9,T10,T11> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T7,T8,T9,T10,T11,T12> Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> join(Tuple6<T7,T8,T9,T10,T11,T12> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T7,T8,T9,T10,T11,T12,T13> Tuple13<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13> join(Tuple7<T7,T8,T9,T10,T11,T12,T13> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T7,T8,T9,T10,T11,T12,T13,T14> Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> join(Tuple8<T7,T8,T9,T10,T11,T12,T13,T14> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T7,T8,T9,T10,T11,T12,T13,T14,T15> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> join(Tuple9<T7,T8,T9,T10,T11,T12,T13,T14,T15> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> join(Tuple10<T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> tuple) {
        return super.join(tuple);
    }

    /**
     * Splices at positions 1
     */
    public Tuple2<Tuple0,Tuple6<T1,T2,T3,T4,T5,T6>> spliceAt1() {
        return splice(1);
    }

    /**
     * Splices at positions 2
     */
    public Tuple2<Tuple1<T1>,Tuple5<T2,T3,T4,T5,T6>> spliceAt2() {
        return splice(2);
    }

    /**
     * Splices at positions 3
     */
    public Tuple2<Tuple2<T1,T2>,Tuple4<T3,T4,T5,T6>> spliceAt3() {
        return splice(3);
    }

    /**
     * Splices at positions 4
     */
    public Tuple2<Tuple3<T1,T2,T3>,Tuple3<T4,T5,T6>> spliceAt4() {
        return splice(4);
    }

    /**
     * Splices at positions 5
     */
    public Tuple2<Tuple4<T1,T2,T3,T4>,Tuple2<T5,T6>> spliceAt5() {
        return splice(5);
    }

    /**
     * Splices at positions 6
     */
    public Tuple2<Tuple5<T1,T2,T3,T4,T5>,Tuple1<T6>> spliceAt6() {
        return splice(6);
    }

    /**
     * Transform this tuple into another object.
     * @param function performs the transformation.
     * @param <R> return tye of the transformed element
     * @return resultant object transformed by this map function.
     */
    public <R> R map(Function6<? super T1,? super T2,? super T3,? super T4,? super T5,? super T6,? extends R> function) {
        return function.apply(t1,t2,t3,t4,t5,t6);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple6<R,T2,T3,T4,T5,T6> mapAt1(Function<? super T1,? extends R> function) {
        return new Tuple6<>(function.apply(t1),t2,t3,t4,t5,t6);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple6<T1,R,T3,T4,T5,T6> mapAt2(Function<? super T2,? extends R> function) {
        return new Tuple6<>(t1,function.apply(t2),t3,t4,t5,t6);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple6<T1,T2,R,T4,T5,T6> mapAt3(Function<? super T3,? extends R> function) {
        return new Tuple6<>(t1,t2,function.apply(t3),t4,t5,t6);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple6<T1,T2,T3,R,T5,T6> mapAt4(Function<? super T4,? extends R> function) {
        return new Tuple6<>(t1,t2,t3,function.apply(t4),t5,t6);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple6<T1,T2,T3,T4,R,T6> mapAt5(Function<? super T5,? extends R> function) {
        return new Tuple6<>(t1,t2,t3,t4,function.apply(t5),t6);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple6<T1,T2,T3,T4,T5,R> mapAt6(Function<? super T6,? extends R> function) {
        return new Tuple6<>(t1,t2,t3,t4,t5,function.apply(t6));
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
     *        .match(all("John","Wellington"), (a,b,c,d,e,f,g) -> System.out.println(a))
     *        .match(all("Alex","Wall",23), (a,b,c,d,e,f,g) -> System.out.println(b))
     * }
     * </pre>
     * @param matcher object to use with this tuple.
     * @param consumer function to execute if match is found.
     * @param <Q> type of matcher.
     * @return this tuple -- useful for multiple matches.
     */
    public <Q extends Matcher> Tuple6<T1,T2,T3,T4,T5,T6> match(final Q matcher, final Consumer6<? super T1,? super T2,? super T3,? super T4,? super T5,? super T6> consumer) {
        Objects.requireNonNull(consumer);
        Tuple6<T1,T2,T3,T4,T5,T6> result = this;
        if (matcher.match(this))
            consumer.accept(t1,t2,t3,t4,t5,t6);

        return result;
    }

    /**
     * Remove element at position 1
     */
    public Tuple5<T2,T3,T4,T5,T6> removeAt1() {
        return remove(1);
    }

    /**
     * Remove element at position 2
     */
    public Tuple5<T1,T3,T4,T5,T6> removeAt2() {
        return remove(2);
    }

    /**
     * Remove element at position 3
     */
    public Tuple5<T1,T2,T4,T5,T6> removeAt3() {
        return remove(3);
    }

    /**
     * Remove element at position 4
     */
    public Tuple5<T1,T2,T3,T5,T6> removeAt4() {
        return remove(4);
    }

    /**
     * Remove element at position 5
     */
    public Tuple5<T1,T2,T3,T4,T6> removeAt5() {
        return remove(5);
    }

    /**
     * Remove element at position 6
     */
    public Tuple5<T1,T2,T3,T4,T5> removeAt6() {
        return remove(6);
    }

    /**
     * Rotates this tuple 1 times to the right
     */
    public Tuple6<T6,T1,T2,T3,T4,T5> rotateRight1() {
        return rotateRight(1);
    }

    /**
     * Rotates this tuple 2 times to the right
     */
    public Tuple6<T5,T6,T1,T2,T3,T4> rotateRight2() {
        return rotateRight(2);
    }

    /**
     * Rotates this tuple 3 times to the right
     */
    public Tuple6<T4,T5,T6,T1,T2,T3> rotateRight3() {
        return rotateRight(3);
    }

    /**
     * Rotates this tuple 4 times to the right
     */
    public Tuple6<T3,T4,T5,T6,T1,T2> rotateRight4() {
        return rotateRight(4);
    }

    /**
     * Rotates this tuple 5 times to the right
     */
    public Tuple6<T2,T3,T4,T5,T6,T1> rotateRight5() {
        return rotateRight(5);
    }

    /**
     * Rotates this tuple 1 time to the left
     */
    public Tuple6<T2,T3,T4,T5,T6,T1> rotateLeft1() {
        return rotateLeft(1);
    }

    /**
     * Rotates this tuple 2 times to the left
     */
    public Tuple6<T3,T4,T5,T6,T1,T2> rotateLeft2() {
        return rotateLeft(2);
    }

    /**
     * Rotates this tuple 3 times to the left
     */
    public Tuple6<T4,T5,T6,T1,T2,T3> rotateLeft3() {
        return rotateLeft(3);
    }

    /**
     * Rotates this tuple 4 times to the left
     */
    public Tuple6<T5,T6,T1,T2,T3,T4> rotateLeft4() {
        return rotateLeft(4);
    }

    /**
     * Rotates this tuple 5 times to the left
     */
    public Tuple6<T6,T1,T2,T3,T4,T5> rotateLeft5() {
        return rotateLeft(5);
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

    /**
     * Truncates tuples at position 5
     */
    public Tuple4<T1,T2,T3,T4> truncateAt5() {
        return truncate(5);
    }

    /**
     * Truncates tuples at position 6
     */
    public Tuple5<T1,T2,T3,T4,T5> truncateAt6() {
        return truncate(6);
    }
}

