package com.excelsior.core.tuple;


import com.excelsior.core.Nullable;

import java.util.function.Function;

/**
 * A tuple with depth of 12
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
 *
 * @author Kevin Henry
 */
public final class Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> extends AbstractTuple {
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

    public Tuple12(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12) {
        super(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12);
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
    }

    /**
     * Converts iterable into a tuple, if possible.
     * <p>
     * Creates a tuple to a depth of 12 from iterable object. If there is
     * insufficient elements, then {@link Nullable} will be empty.
     *
     * @param iterable Iterable object
     * @param <T> iterable type.
     * @return A tuple in {@link Nullable} object container.
     */
    public static <T> Nullable<Tuple12<T,T,T,T,T,T,T,T,T,T,T,T>> fromIterable(Iterable<T> iterable) {
        return Tuples.fromIterable(iterable, 12);
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

    public T7 value7() {
        return t7;
    }

    public T8 value8() {
        return t8;
    }

    public T9 value9() {
        return t9;
    }

    public T10 value10() {
        return t10;
    }

    public T11 value11() {
        return t11;
    }

    public T12 value12() {
        return t12;
    }

    /**
     * Add value at position 1
     */
    public <T> Tuple13<T,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> addAt1(T value) {
        return add(1,value);
    }

    /**
     * Add value at position 2
     */
    public <T> Tuple13<T1,T,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> addAt2(T value) {
        return add(2,value);
    }

    /**
     * Add value at position 3
     */
    public <T> Tuple13<T1,T2,T,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> addAt3(T value) {
        return add(3,value);
    }

    /**
     * Add value at position 4
     */
    public <T> Tuple13<T1,T2,T3,T,T4,T5,T6,T7,T8,T9,T10,T11,T12> addAt4(T value) {
        return add(4,value);
    }

    /**
     * Add value at position 5
     */
    public <T> Tuple13<T1,T2,T3,T4,T,T5,T6,T7,T8,T9,T10,T11,T12> addAt5(T value) {
        return add(5,value);
    }

    /**
     * Add value at position 6
     */
    public <T> Tuple13<T1,T2,T3,T4,T5,T,T6,T7,T8,T9,T10,T11,T12> addAt6(T value) {
        return add(6,value);
    }

    /**
     * Add value at position 7
     */
    public <T> Tuple13<T1,T2,T3,T4,T5,T6,T,T7,T8,T9,T10,T11,T12> addAt7(T value) {
        return add(7,value);
    }

    /**
     * Add value at position 8
     */
    public <T> Tuple13<T1,T2,T3,T4,T5,T6,T7,T,T8,T9,T10,T11,T12> addAt8(T value) {
        return add(8,value);
    }

    /**
     * Add value at position 9
     */
    public <T> Tuple13<T1,T2,T3,T4,T5,T6,T7,T8,T,T9,T10,T11,T12> addAt9(T value) {
        return add(9,value);
    }

    /**
     * Add value at position 10
     */
    public <T> Tuple13<T1,T2,T3,T4,T5,T6,T7,T8,T9,T,T10,T11,T12> addAt10(T value) {
        return add(10,value);
    }

    /**
     * Add value at position 11
     */
    public <T> Tuple13<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T,T11,T12> addAt11(T value) {
        return add(11,value);
    }

    /**
     * Add value at position 12
     */
    public <T> Tuple13<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T,T12> addAt12(T value) {
        return add(12,value);
    }

    /**
     * Hop to position/value 1
     */
    public Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> hopTo1() {
        return hop(1);
    }

    /**
     * Hop to position/value 2
     */
    public Tuple11<T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> hopTo2() {
        return hop(2);
    }

    /**
     * Hop to position/value 3
     */
    public Tuple10<T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> hopTo3() {
        return hop(3);
    }

    /**
     * Hop to position/value 4
     */
    public Tuple9<T4,T5,T6,T7,T8,T9,T10,T11,T12> hopTo4() {
        return hop(4);
    }

    /**
     * Hop to position/value 5
     */
    public Tuple8<T5,T6,T7,T8,T9,T10,T11,T12> hopTo5() {
        return hop(5);
    }

    /**
     * Hop to position/value 6
     */
    public Tuple7<T6,T7,T8,T9,T10,T11,T12> hopTo6() {
        return hop(6);
    }

    /**
     * Hop to position/value 7
     */
    public Tuple6<T7,T8,T9,T10,T11,T12> hopTo7() {
        return hop(7);
    }

    /**
     * Hop to position/value 8
     */
    public Tuple5<T8,T9,T10,T11,T12> hopTo8() {
        return hop(8);
    }

    /**
     * Hop to position/value 9
     */
    public Tuple4<T9,T10,T11,T12> hopTo9() {
        return hop(9);
    }

    /**
     * Hop to position/value 10
     */
    public Tuple3<T10,T11,T12> hopTo10() {
        return hop(10);
    }

    /**
     * Hop to position/value 11
     */
    public Tuple2<T11,T12> hopTo11() {
        return hop(11);
    }

    /**
     * Hop to position/value 12
     */
    public Tuple1<T12> hopTo12() {
        return hop(12);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> join(Tuple0 tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T13> Tuple13<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13> join(Tuple1<T13> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T13,T14> Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> join(Tuple2<T13,T14> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T13,T14,T15> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> join(Tuple3<T13,T14,T15> tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T13,T14,T15,T16> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> join(Tuple4<T13,T14,T15,T16> tuple) {
        return super.join(tuple);
    }

    /**
     * Splices at positions 1
     */
    public Tuple2<Tuple0,Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12>> spliceAt1() {
        return splice(1);
    }

    /**
     * Splices at positions 2
     */
    public Tuple2<Tuple1<T1>,Tuple11<T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12>> spliceAt2() {
        return splice(2);
    }

    /**
     * Splices at positions 3
     */
    public Tuple2<Tuple2<T1,T2>,Tuple10<T3,T4,T5,T6,T7,T8,T9,T10,T11,T12>> spliceAt3() {
        return splice(3);
    }

    /**
     * Splices at positions 4
     */
    public Tuple2<Tuple3<T1,T2,T3>,Tuple9<T4,T5,T6,T7,T8,T9,T10,T11,T12>> spliceAt4() {
        return splice(4);
    }

    /**
     * Splices at positions 5
     */
    public Tuple2<Tuple4<T1,T2,T3,T4>,Tuple8<T5,T6,T7,T8,T9,T10,T11,T12>> spliceAt5() {
        return splice(5);
    }

    /**
     * Splices at positions 6
     */
    public Tuple2<Tuple5<T1,T2,T3,T4,T5>,Tuple7<T6,T7,T8,T9,T10,T11,T12>> spliceAt6() {
        return splice(6);
    }

    /**
     * Splices at positions 7
     */
    public Tuple2<Tuple6<T1,T2,T3,T4,T5,T6>,Tuple6<T7,T8,T9,T10,T11,T12>> spliceAt7() {
        return splice(7);
    }

    /**
     * Splices at positions 8
     */
    public Tuple2<Tuple7<T1,T2,T3,T4,T5,T6,T7>,Tuple5<T8,T9,T10,T11,T12>> spliceAt8() {
        return splice(8);
    }

    /**
     * Splices at positions 9
     */
    public Tuple2<Tuple8<T1,T2,T3,T4,T5,T6,T7,T8>,Tuple4<T9,T10,T11,T12>> spliceAt9() {
        return splice(9);
    }

    /**
     * Splices at positions 10
     */
    public Tuple2<Tuple9<T1,T2,T3,T4,T5,T6,T7,T8,T9>,Tuple3<T10,T11,T12>> spliceAt10() {
        return splice(10);
    }

    /**
     * Splices at positions 11
     */
    public Tuple2<Tuple10<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10>,Tuple2<T11,T12>> spliceAt11() {
        return splice(11);
    }

    /**
     * Splices at positions 12
     */
    public Tuple2<Tuple11<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11>,Tuple1<T12>> spliceAt12() {
        return splice(12);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple12<R,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> transform1(Function<? super T1,? extends R> function) {
        return new Tuple12<>(function.apply(t1),t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple12<T1,R,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> transform2(Function<? super T2,? extends R> function) {
        return new Tuple12<>(t1,function.apply(t2),t3,t4,t5,t6,t7,t8,t9,t10,t11,t12);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple12<T1,T2,R,T4,T5,T6,T7,T8,T9,T10,T11,T12> transform3(Function<? super T3,? extends R> function) {
        return new Tuple12<>(t1,t2,function.apply(t3),t4,t5,t6,t7,t8,t9,t10,t11,t12);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple12<T1,T2,T3,R,T5,T6,T7,T8,T9,T10,T11,T12> transform4(Function<? super T4,? extends R> function) {
        return new Tuple12<>(t1,t2,t3,function.apply(t4),t5,t6,t7,t8,t9,t10,t11,t12);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple12<T1,T2,T3,T4,R,T6,T7,T8,T9,T10,T11,T12> transform5(Function<? super T5,? extends R> function) {
        return new Tuple12<>(t1,t2,t3,t4,function.apply(t5),t6,t7,t8,t9,t10,t11,t12);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple12<T1,T2,T3,T4,T5,R,T7,T8,T9,T10,T11,T12> transform6(Function<? super T6,? extends R> function) {
        return new Tuple12<>(t1,t2,t3,t4,t5,function.apply(t6),t7,t8,t9,t10,t11,t12);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple12<T1,T2,T3,T4,T5,T6,R,T8,T9,T10,T11,T12> transform7(Function<? super T7,? extends R> function) {
        return new Tuple12<>(t1,t2,t3,t4,t5,t6,function.apply(t7),t8,t9,t10,t11,t12);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple12<T1,T2,T3,T4,T5,T6,T7,R,T9,T10,T11,T12> transform8(Function<? super T8,? extends R> function) {
        return new Tuple12<>(t1,t2,t3,t4,t5,t6,t7,function.apply(t8),t9,t10,t11,t12);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,R,T10,T11,T12> transform9(Function<? super T9,? extends R> function) {
        return new Tuple12<>(t1,t2,t3,t4,t5,t6,t7,t8,function.apply(t9),t10,t11,t12);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,T9,R,T11,T12> transform10(Function<? super T10,? extends R> function) {
        return new Tuple12<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,function.apply(t10),t11,t12);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,R,T12> transform11(Function<? super T11,? extends R> function) {
        return new Tuple12<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,function.apply(t11),t12);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,R> transform12(Function<? super T12,? extends R> function) {
        return new Tuple12<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,function.apply(t12));
    }
}
