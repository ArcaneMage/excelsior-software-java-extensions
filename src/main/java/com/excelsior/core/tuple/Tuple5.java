package com.excelsior.core.tuple;


import com.excelsior.core.Nullable;

import java.util.function.Function;

/**
 * A tuple with depth of 5
 *
 * @param <T1> type of 1st element
 * @param <T2> type of 2nd element
 * @param <T3> type of 3rd element
 * @param <T4> type of 4th element
 * @param <T5> type of 5th element
 *
 * @author Kevin Henry
 */
public final class Tuple5<T1,T2,T3,T4,T5> extends AbstractTuple {
    private final T1 t1;
    private final T2 t2;
    private final T3 t3;
    private final T4 t4;
    private final T5 t5;

    public Tuple5(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        super(t1,t2,t3,t4,t5);
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
    }

    /**
     * Converts iterable into a tuple, if possible.
     * <p>
     * Creates a tuple to a depth of 5 from iterable object. If there is
     * insufficient elements, then {@link Nullable} will be empty.
     *
     * @param iterable Iterable object
     * @param <T> iterable type.
     * @return A tuple in {@link Nullable} object container.
     */
    public static <T> Nullable<Tuple5<T,T,T,T,T>> fromIterable(Iterable<T> iterable) {
        return Tuples.fromIterable(iterable, 5);
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

    /**
     * Joins a tuple to this tuple.
     * @param value a tuple object.
     */
    public <T> Tuple6<T1,T2,T3,T4,T5,T> join(T value) {
        return new Tuple6<>(t1,t2,t3,t4,t5,value);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T6> Tuple6<T1,T2,T3,T4,T5,T6> join(Tuple1<T6> tuple) {
        return new Tuple6<>(t1,t2,t3,t4,t5,tuple.value1());
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T6,T7> Tuple7<T1,T2,T3,T4,T5,T6,T7> join(Tuple2<T6,T7> tuple) {
        return new Tuple7<>(t1,t2,t3,t4,t5,tuple.value1(),tuple.value2());
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T6,T7,T8> Tuple8<T1,T2,T3,T4,T5,T6,T7,T8> join(Tuple3<T6,T7,T8> tuple) {
        return new Tuple8<>(t1,t2,t3,t4,t5,tuple.value1(),tuple.value2(),tuple.value3());
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T6,T7,T8,T9> Tuple9<T1,T2,T3,T4,T5,T6,T7,T8,T9> join(Tuple4<T6,T7,T8,T9> tuple) {
        return new Tuple9<>(t1,t2,t3,t4,t5,tuple.value1(),tuple.value2(),tuple.value3(),tuple.value4());
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T6,T7,T8,T9,T10> Tuple10<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10> join(Tuple5<T6,T7,T8,T9,T10> tuple) {
        return new Tuple10<>(t1,t2,t3,t4,t5,tuple.value1(),tuple.value2(),tuple.value3(),tuple.value4(),tuple.value5());
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T6,T7,T8,T9,T10,T11> Tuple11<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11> join(Tuple6<T6,T7,T8,T9,T10,T11> tuple) {
        return new Tuple11<>(t1,t2,t3,t4,t5,tuple.value1(),tuple.value2(),tuple.value3(),tuple.value4(),tuple.value5(),tuple.value6());
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T6,T7,T8,T9,T10,T11,T12> Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> join(Tuple7<T6,T7,T8,T9,T10,T11,T12> tuple) {
        return new Tuple12<>(t1,t2,t3,t4,t5,tuple.value1(),tuple.value2(),tuple.value3(),tuple.value4(),tuple.value5(),tuple.value6(),tuple.value7());
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T6,T7,T8,T9,T10,T11,T12,T13> Tuple13<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13> join(Tuple8<T6,T7,T8,T9,T10,T11,T12,T13> tuple) {
        return new Tuple13<>(t1,t2,t3,t4,t5,tuple.value1(),tuple.value2(),tuple.value3(),tuple.value4(),tuple.value5(),tuple.value6(),tuple.value7(),tuple.value8());
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T6,T7,T8,T9,T10,T11,T12,T13,T14> Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> join(Tuple9<T6,T7,T8,T9,T10,T11,T12,T13,T14> tuple) {
        return new Tuple14<>(t1,t2,t3,t4,t5,tuple.value1(),tuple.value2(),tuple.value3(),tuple.value4(),tuple.value5(),tuple.value6(),tuple.value7(),tuple.value8(),tuple.value9());
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> join(Tuple10<T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> tuple) {
        return new Tuple15<>(t1,t2,t3,t4,t5,tuple.value1(),tuple.value2(),tuple.value3(),tuple.value4(),tuple.value5(),tuple.value6(),tuple.value7(),tuple.value8(),tuple.value9(),tuple.value10());
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> join(Tuple11<T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> tuple) {
        return new Tuple16<>(t1,t2,t3,t4,t5,tuple.value1(),tuple.value2(),tuple.value3(),tuple.value4(),tuple.value5(),tuple.value6(),tuple.value7(),tuple.value8(),tuple.value9(),tuple.value10(),tuple.value11());
    }

    /**
     * Splices this tuple into two partitions at element position 1
     */
    public Tuple2<Tuple1<T1>,Tuple4<T2,T3,T4,T5>> splice1() { return splice(1); }

    /**
     * Splices this tuple into two partitions at element position 2
     */
    public Tuple2<Tuple2<T1,T2>,Tuple3<T3,T4,T5>> splice2() { return splice(2); }

    /**
     * Splices this tuple into two partitions at element position 3
     */
    public Tuple2<Tuple3<T1,T2,T3>,Tuple2<T4,T5>> splice3() { return splice(3); }

    /**
     * Splices this tuple into two partitions at element position 4
     */
    public Tuple2<Tuple4<T1,T2,T3,T4>,Tuple1<T5>> splice4() { return splice(4); }

    /**
     * Truncates remaining tuples to a depth of 1
     */
    public Tuple1<T1> truncate1() {
        return new Tuple1<>(t1);
    }

    /**
     * Truncates remaining tuples to a depth of 2
     */
    public Tuple2<T1,T2> truncate2() {
        return new Tuple2<>(t1,t2);
    }

    /**
     * Truncates remaining tuples to a depth of 3
     */
    public Tuple3<T1,T2,T3> truncate3() {
        return new Tuple3<>(t1,t2,t3);
    }

    /**
     * Truncates remaining tuples to a depth of 4
     */
    public Tuple4<T1,T2,T3,T4> truncate4() {
        return new Tuple4<>(t1,t2,t3,t4);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple5<R,T2,T3,T4,T5> transform1(Function<? super T1,? extends R> function) {
        return new Tuple5<>(function.apply(t1),t2,t3,t4,t5);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple5<T1,R,T3,T4,T5> transform2(Function<? super T2,? extends R> function) {
        return new Tuple5<>(t1,function.apply(t2),t3,t4,t5);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple5<T1,T2,R,T4,T5> transform3(Function<? super T3,? extends R> function) {
        return new Tuple5<>(t1,t2,function.apply(t3),t4,t5);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple5<T1,T2,T3,R,T5> transform4(Function<? super T4,? extends R> function) {
        return new Tuple5<>(t1,t2,t3,function.apply(t4),t5);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple5<T1,T2,T3,T4,R> transform5(Function<? super T5,? extends R> function) {
        return new Tuple5<>(t1,t2,t3,t4,function.apply(t5));
    }
}