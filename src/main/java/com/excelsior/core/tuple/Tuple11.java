package com.excelsior.core.tuple;


import com.excelsior.core.Nullable;

import java.util.function.Function;

/**
 * A tuple with depth of 11
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
 *
 * @author Kevin Henry
 */
public final class Tuple11<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11> extends AbstractTuple {
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

    public Tuple11(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11) {
        super(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11);
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
    }

    /**
     * Converts iterable into a tuple, if possible.
     * <p>
     * Creates a tuple to a depth of 11 from iterable object. If there is
     * insufficient elements, then {@link Nullable} will be empty.
     *
     * @param iterable Iterable object
     * @param <T> iterable type.
     * @return A tuple in {@link Nullable} object container.
     */
    public static <T> Nullable<Tuple11<T,T,T,T,T,T,T,T,T,T,T>> fromIterable(Iterable<T> iterable) {
        return Tuples.fromIterable(iterable, 11);
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

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple11<R,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11> transform1(Function<? super T1,? extends R> function) {
        return new Tuple11<>(function.apply(t1),t2,t3,t4,t5,t6,t7,t8,t9,t10,t11);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple11<T1,R,T3,T4,T5,T6,T7,T8,T9,T10,T11> transform2(Function<? super T2,? extends R> function) {
        return new Tuple11<>(t1,function.apply(t2),t3,t4,t5,t6,t7,t8,t9,t10,t11);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple11<T1,T2,R,T4,T5,T6,T7,T8,T9,T10,T11> transform3(Function<? super T3,? extends R> function) {
        return new Tuple11<>(t1,t2,function.apply(t3),t4,t5,t6,t7,t8,t9,t10,t11);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple11<T1,T2,T3,R,T5,T6,T7,T8,T9,T10,T11> transform4(Function<? super T4,? extends R> function) {
        return new Tuple11<>(t1,t2,t3,function.apply(t4),t5,t6,t7,t8,t9,t10,t11);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple11<T1,T2,T3,T4,R,T6,T7,T8,T9,T10,T11> transform5(Function<? super T5,? extends R> function) {
        return new Tuple11<>(t1,t2,t3,t4,function.apply(t5),t6,t7,t8,t9,t10,t11);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple11<T1,T2,T3,T4,T5,R,T7,T8,T9,T10,T11> transform6(Function<? super T6,? extends R> function) {
        return new Tuple11<>(t1,t2,t3,t4,t5,function.apply(t6),t7,t8,t9,t10,t11);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple11<T1,T2,T3,T4,T5,T6,R,T8,T9,T10,T11> transform7(Function<? super T7,? extends R> function) {
        return new Tuple11<>(t1,t2,t3,t4,t5,t6,function.apply(t7),t8,t9,t10,t11);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple11<T1,T2,T3,T4,T5,T6,T7,R,T9,T10,T11> transform8(Function<? super T8,? extends R> function) {
        return new Tuple11<>(t1,t2,t3,t4,t5,t6,t7,function.apply(t8),t9,t10,t11);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple11<T1,T2,T3,T4,T5,T6,T7,T8,R,T10,T11> transform9(Function<? super T9,? extends R> function) {
        return new Tuple11<>(t1,t2,t3,t4,t5,t6,t7,t8,function.apply(t9),t10,t11);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple11<T1,T2,T3,T4,T5,T6,T7,T8,T9,R,T11> transform10(Function<? super T10,? extends R> function) {
        return new Tuple11<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,function.apply(t10),t11);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple11<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,R> transform11(Function<? super T11,? extends R> function) {
        return new Tuple11<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,function.apply(t11));
    }
}
