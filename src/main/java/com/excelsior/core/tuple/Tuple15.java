package com.excelsior.core.tuple;


import com.excelsior.core.Nullable;

import java.util.function.Function;

/**
 * A tuple with depth of 15
 *
 * @param <T1> type of 1st element
 * @param <T2> type of 2nd element
 * @param <T3> type of 3rd element
 * @param <T4> type of 4th element
 * @param <T5> type of 5th element
 * @param <T6> type of 6th element
 * @param <T7> type of 7th element
 * @param <T8> type of 8th element
 * @param <T9> type of 9th element
 * @param <T10> type of 10th element
 * @param <T11> type of 11th element
 * @param <T12> type of 12th element
 * @param <T13> type of 13th element
 * @param <T14> type of 14th element
 * @param <T15> type of 15th element
 *
 * @author Kevin Henry
 */
public final class Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> extends AbstractTuple {
    private final T1 t1;
    private final T2 t2;
    private final T3 t3;
    private final T4 t4;
    private final T5 t5;
    private final T6 t6;
    private final T7 t7;
    private final T8 t8;
    private final T9 t9;
    private final T10 t10;
    private final T11 t11;
    private final T12 t12;
    private final T13 t13;
    private final T14 t14;
    private final T15 t15;

    public Tuple15(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15) {
        super(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15);
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
        this.t6 = t6;
        this.t7 = t7;
        this.t8 = t8;
        this.t9 = t9;
        this.t10 = t10;
        this.t11 = t11;
        this.t12 = t12;
        this.t13 = t13;
        this.t14 = t14;
        this.t15 = t15;
    }

    /**
     * Converts iterable into a tuple, if possible.
     * <p>
     * Creates a tuple to a depth of 15 from iterable object. If there is
     * insufficient elements, then {@link Nullable} will be empty.
     *
     * @param iterable Iterable object
     * @param <T> iterable type.
     * @return A tuple in {@link Nullable} object container.
     */
    public static <T> Nullable<Tuple15<T,T,T,T,T,T,T,T,T,T,T,T,T,T,T>> fromIterable(Iterable<T> iterable) {
        return Tuples.fromIterable(iterable, 15);
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

    public T7 value7() { return t7; }

    public T8 value8() { return t8; }

    public T9 value9() { return t9; }

    public T10 value10() { return t10; }

    public T11 value11() { return t11; }

    public T12 value12() { return t12; }

    public T13 value13() { return t13; }

    public T14 value14() { return t14; }

    public T15 value15() { return t15; }

    /**
     * Joins a tuple to this tuple.
     * @param value a tuple object.
     */
    public <T> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T> join(T value) {
        return new Tuple16<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,value);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T16> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> join(Tuple1<T16> tuple) {
        return new Tuple16<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,tuple.value1());
    }

    /**
     * Splices this tuple into two partitions at element position 1
     */
    public Tuple2<Tuple1<T1>,Tuple14<T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15>> splice1() { return splice(1); }

    /**
     * Splices this tuple into two partitions at element position 2
     */
    public Tuple2<Tuple2<T1,T2>,Tuple13<T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15>> splice2() { return splice(2); }

    /**
     * Splices this tuple into two partitions at element position 3
     */
    public Tuple2<Tuple3<T1,T2,T3>,Tuple12<T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15>> splice3() { return splice(3); }

    /**
     * Splices this tuple into two partitions at element position 4
     */
    public Tuple2<Tuple4<T1,T2,T3,T4>,Tuple11<T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15>> splice4() { return splice(4); }

    /**
     * Splices this tuple into two partitions at element position 5
     */
    public Tuple2<Tuple5<T1,T2,T3,T4,T5>,Tuple10<T6,T7,T8,T9,T10,T11,T12,T13,T14,T15>> splice5() { return splice(5); }

    /**
     * Splices this tuple into two partitions at element position 6
     */
    public Tuple2<Tuple6<T1,T2,T3,T4,T5,T6>,Tuple9<T7,T8,T9,T10,T11,T12,T13,T14,T15>> splice6() { return splice(6); }

    /**
     * Splices this tuple into two partitions at element position 7
     */
    public Tuple2<Tuple7<T1,T2,T3,T4,T5,T6,T7>,Tuple8<T8,T9,T10,T11,T12,T13,T14,T15>> splice7() { return splice(7); }

    /**
     * Splices this tuple into two partitions at element position 8
     */
    public Tuple2<Tuple8<T1,T2,T3,T4,T5,T6,T7,T8>,Tuple7<T9,T10,T11,T12,T13,T14,T15>> splice8() { return splice(8); }

    /**
     * Splices this tuple into two partitions at element position 9
     */
    public Tuple2<Tuple9<T1,T2,T3,T4,T5,T6,T7,T8,T9>,Tuple6<T10,T11,T12,T13,T14,T15>> splice9() { return splice(9); }

    /**
     * Splices this tuple into two partitions at element position 10
     */
    public Tuple2<Tuple10<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10>,Tuple5<T11,T12,T13,T14,T15>> splice10() { return splice(10); }

    /**
     * Splices this tuple into two partitions at element position 11
     */
    public Tuple2<Tuple11<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11>,Tuple4<T12,T13,T14,T15>> splice11() { return splice(11); }

    /**
     * Splices this tuple into two partitions at element position 12
     */
    public Tuple2<Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12>,Tuple3<T13,T14,T15>> splice12() { return splice(12); }

    /**
     * Splices this tuple into two partitions at element position 13
     */
    public Tuple2<Tuple13<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13>,Tuple2<T14,T15>> splice13() { return splice(13); }

    /**
     * Splices this tuple into two partitions at element position 14
     */
    public Tuple2<Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14>,Tuple1<T15>> splice14() { return splice(14); }

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
     * Truncates remaining tuples to a depth of 5
     */
    public Tuple5<T1,T2,T3,T4,T5> truncate5() {
        return new Tuple5<>(t1,t2,t3,t4,t5);
    }

    /**
     * Truncates remaining tuples to a depth of 6
     */
    public Tuple6<T1,T2,T3,T4,T5,T6> truncate6() {
        return new Tuple6<>(t1,t2,t3,t4,t5,t6);
    }

    /**
     * Truncates remaining tuples to a depth of 7
     */
    public Tuple7<T1,T2,T3,T4,T5,T6,T7> truncate7() {
        return new Tuple7<>(t1,t2,t3,t4,t5,t6,t7);
    }

    /**
     * Truncates remaining tuples to a depth of 8
     */
    public Tuple8<T1,T2,T3,T4,T5,T6,T7,T8> truncate8() {
        return new Tuple8<>(t1,t2,t3,t4,t5,t6,t7,t8);
    }

    /**
     * Truncates remaining tuples to a depth of 9
     */
    public Tuple9<T1,T2,T3,T4,T5,T6,T7,T8,T9> truncate9() {
        return new Tuple9<>(t1,t2,t3,t4,t5,t6,t7,t8,t9);
    }

    /**
     * Truncates remaining tuples to a depth of 10
     */
    public Tuple10<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10> truncate10() {
        return new Tuple10<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10);
    }

    /**
     * Truncates remaining tuples to a depth of 11
     */
    public Tuple11<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11> truncate11() {
        return new Tuple11<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11);
    }

    /**
     * Truncates remaining tuples to a depth of 12
     */
    public Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> truncate12() {
        return new Tuple12<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12);
    }

    /**
     * Truncates remaining tuples to a depth of 13
     */
    public Tuple13<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13> truncate13() {
        return new Tuple13<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13);
    }

    /**
     * Truncates remaining tuples to a depth of 14
     */
    public Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> truncate14() {
        return new Tuple14<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<R,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> transform1(Function<? super T1,? extends R> function) {
        return new Tuple15<>(function.apply(t1),t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,R,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> transform2(Function<? super T2,? extends R> function) {
        return new Tuple15<>(t1,function.apply(t2),t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,R,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> transform3(Function<? super T3,? extends R> function) {
        return new Tuple15<>(t1,t2,function.apply(t3),t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,R,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> transform4(Function<? super T4,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,function.apply(t4),t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,R,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> transform5(Function<? super T5,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,function.apply(t5),t6,t7,t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,R,T7,T8,T9,T10,T11,T12,T13,T14,T15> transform6(Function<? super T6,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,function.apply(t6),t7,t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,R,T8,T9,T10,T11,T12,T13,T14,T15> transform7(Function<? super T7,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,function.apply(t7),t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,R,T9,T10,T11,T12,T13,T14,T15> transform8(Function<? super T8,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,function.apply(t8),t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,R,T10,T11,T12,T13,T14,T15> transform9(Function<? super T9,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,t8,function.apply(t9),t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,R,T11,T12,T13,T14,T15> transform10(Function<? super T10,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,function.apply(t10),t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,R,T12,T13,T14,T15> transform11(Function<? super T11,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,function.apply(t11),t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,R,T13,T14,T15> transform12(Function<? super T12,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,function.apply(t12),t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,R,T14,T15> transform13(Function<? super T13,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,function.apply(t13),t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,R,T15> transform14(Function<? super T14,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,function.apply(t14),t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,R> transform15(Function<? super T15,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,function.apply(t15));
    }
}