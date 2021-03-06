package org.javalaboratories.core.tuple;


import org.javalaboratories.core.Maybe;
import org.javalaboratories.core.function.Consumer15;
import org.javalaboratories.core.function.Function15;

import java.util.Objects;
import java.util.function.Function;

import static org.javalaboratories.core.tuple.Tuple.of;

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
@SuppressWarnings("WeakerAccess")
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
     * insufficient elements, then {@link Maybe} will be empty.
     *
     * @param iterable Iterable object
     * @param <T> iterable type.
     * @return A tuple in {@link Maybe} object container.
     */
    public static <T> Maybe<Tuple15<T,T,T,T,T,T,T,T,T,T,T,T,T,T,T>> fromIterable(Iterable<T> iterable) {
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

    public T13 value13() {
        return t13;
    }

    public T14 value14() {
        return t14;
    }

    public T15 value15() {
        return t15;
    }

    /**
     * Add value position 1
     */
    public <T> Tuple16<T,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> addAt1(T value) {
        return add(1,value);
    }

    /**
     * Add value position 2
     */
    public <T> Tuple16<T1,T,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> addAt2(T value) {
        return add(2,value);
    }

    /**
     * Add value position 3
     */
    public <T> Tuple16<T1,T2,T,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> addAt3(T value) {
        return add(3,value);
    }

    /**
     * Add value position 4
     */
    public <T> Tuple16<T1,T2,T3,T,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> addAt4(T value) {
        return add(4,value);
    }

    /**
     * Add value position 5
     */
    public <T> Tuple16<T1,T2,T3,T4,T,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> addAt5(T value) {
        return add(5,value);
    }

    /**
     * Add value position 6
     */
    public <T> Tuple16<T1,T2,T3,T4,T5,T,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> addAt6(T value) {
        return add(6,value);
    }

    /**
     * Add value position 7
     */
    public <T> Tuple16<T1,T2,T3,T4,T5,T6,T,T7,T8,T9,T10,T11,T12,T13,T14,T15> addAt7(T value) {
        return add(7,value);
    }

    /**
     * Add value position 8
     */
    public <T> Tuple16<T1,T2,T3,T4,T5,T6,T7,T,T8,T9,T10,T11,T12,T13,T14,T15> addAt8(T value) {
        return add(8,value);
    }

    /**
     * Add value position 9
     */
    public <T> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T,T9,T10,T11,T12,T13,T14,T15> addAt9(T value) {
        return add(9,value);
    }

    /**
     * Add value position 10
     */
    public <T> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T9,T,T10,T11,T12,T13,T14,T15> addAt10(T value) {
        return add(10,value);
    }

    /**
     * Add value position 11
     */
    public <T> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T,T11,T12,T13,T14,T15> addAt11(T value) {
        return add(11,value);
    }

    /**
     * Add value position 12
     */
    public <T> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T,T12,T13,T14,T15> addAt12(T value) {
        return add(12,value);
    }

    /**
     * Add value position 13
     */
    public <T> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T,T13,T14,T15> addAt13(T value) {
        return add(13,value);
    }

    /**
     * Add value position 14
     */
    public <T> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T,T14,T15> addAt14(T value) {
        return add(14,value);
    }

    /**
     * Add value position 15
     */
    public <T> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T,T15> addAt15(T value) {
        return add(15,value);
    }

    /**
     * Hop to position/value 1
     */
    public Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> hopTo1() {
        return hop(1);
    }

    /**
     * Hop to position/value 2
     */
    public Tuple14<T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> hopTo2() {
        return hop(2);
    }

    /**
     * Hop to position/value 3
     */
    public Tuple13<T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> hopTo3() {
        return hop(3);
    }

    /**
     * Hop to position/value 4
     */
    public Tuple12<T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> hopTo4() {
        return hop(4);
    }

    /**
     * Hop to position/value 5
     */
    public Tuple11<T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> hopTo5() {
        return hop(5);
    }

    /**
     * Hop to position/value 6
     */
    public Tuple10<T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> hopTo6() {
        return hop(6);
    }

    /**
     * Hop to position/value 7
     */
    public Tuple9<T7,T8,T9,T10,T11,T12,T13,T14,T15> hopTo7() {
        return hop(7);
    }

    /**
     * Hop to position/value 8
     */
    public Tuple8<T8,T9,T10,T11,T12,T13,T14,T15> hopTo8() {
        return hop(8);
    }

    /**
     * Hop to position/value 9
     */
    public Tuple7<T9,T10,T11,T12,T13,T14,T15> hopTo9() {
        return hop(9);
    }

    /**
     * Hop to position/value 10
     */
    public Tuple6<T10,T11,T12,T13,T14,T15> hopTo10() {
        return hop(10);
    }

    /**
     * Hop to position/value 11
     */
    public Tuple5<T11,T12,T13,T14,T15> hopTo11() {
        return hop(11);
    }

    /**
     * Hop to position/value 12
     */
    public Tuple4<T12,T13,T14,T15> hopTo12() {
        return hop(12);
    }

    /**
     * Hop to position/value 13
     */
    public Tuple3<T13,T14,T15> hopTo13() {
        return hop(13);
    }

    /**
     * Hop to position/value 14
     */
    public Tuple2<T14,T15> hopTo14() {
        return hop(14);
    }

    /**
     * Hop to position/value 15
     */
    public Tuple1<T15> hopTo15() {
        return hop(15);
    }

    /**
     * Splices at positions 1
     */
    public Tuple2<Tuple0,Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15>> spliceAt1() {
        return splice(1);
    }

    /**
     * Splices at positions 2
     */
    public Tuple2<Tuple1<T1>,Tuple14<T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15>> spliceAt2() {
        return splice(2);
    }

    /**
     * Splices at positions 3
     */
    public Tuple2<Tuple2<T1,T2>,Tuple13<T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15>> spliceAt3() {
        return splice(3);
    }

    /**
     * Splices at positions 4
     */
    public Tuple2<Tuple3<T1,T2,T3>,Tuple12<T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15>> spliceAt4() {
        return splice(4);
    }

    /**
     * Splices at positions 5
     */
    public Tuple2<Tuple4<T1,T2,T3,T4>,Tuple11<T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15>> spliceAt5() {
        return splice(5);
    }

    /**
     * Splices at positions 6
     */
    public Tuple2<Tuple5<T1,T2,T3,T4,T5>,Tuple10<T6,T7,T8,T9,T10,T11,T12,T13,T14,T15>> spliceAt6() {
        return splice(6);
    }

    /**
     * Splices at positions 7
     */
    public Tuple2<Tuple6<T1,T2,T3,T4,T5,T6>,Tuple9<T7,T8,T9,T10,T11,T12,T13,T14,T15>> spliceAt7() {
        return splice(7);
    }

    /**
     * Splices at positions 8
     */
    public Tuple2<Tuple7<T1,T2,T3,T4,T5,T6,T7>,Tuple8<T8,T9,T10,T11,T12,T13,T14,T15>> spliceAt8() {
        return splice(8);
    }

    /**
     * Splices at positions 9
     */
    public Tuple2<Tuple8<T1,T2,T3,T4,T5,T6,T7,T8>,Tuple7<T9,T10,T11,T12,T13,T14,T15>> spliceAt9() {
        return splice(9);
    }

    /**
     * Splices at positions 10
     */
    public Tuple2<Tuple9<T1,T2,T3,T4,T5,T6,T7,T8,T9>,Tuple6<T10,T11,T12,T13,T14,T15>> spliceAt10() {
        return splice(10);
    }

    /**
     * Splices at positions 11
     */
    public Tuple2<Tuple10<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10>,Tuple5<T11,T12,T13,T14,T15>> spliceAt11() {
        return splice(11);
    }

    /**
     * Splices at positions 12
     */
    public Tuple2<Tuple11<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11>,Tuple4<T12,T13,T14,T15>> spliceAt12() {
        return splice(12);
    }

    /**
     * Splices at positions 13
     */
    public Tuple2<Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12>,Tuple3<T13,T14,T15>> spliceAt13() {
        return splice(13);
    }

    /**
     * Splices at positions 14
     */
    public Tuple2<Tuple13<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13>,Tuple2<T14,T15>> spliceAt14() {
        return splice(14);
    }

    /**
     * Splices at positions 15
     */
    public Tuple2<Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14>,Tuple1<T15>> spliceAt15() {
        return splice(15);
    }

    /**
     * Joins a tuple to this tuple.
     * @param value a tuple object.
     */
    public <T> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T> join(T value) {
        return join(of(value));
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public  Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> join(Tuple0 tuple) {
        return super.join(tuple);
    }

    /**
     * Joins a tuple to this tuple.
     * @param tuple a tuple object.
     */
    public <T16> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> join(Tuple1<T16> tuple) {
        return super.join(tuple);
    }

    /**
     * Transform this tuple into another object.
     * @param function performs the transformation.
     * @param <R> return tye of the transformed element
     * @return resultant object transformed by this map function.
     */
    public <R> R map(Function15<? super T1,? super T2,? super T3,? super T4,? super T5,? super T6,? super T7,? super T8,? super T9,? super T10,? super T11,? super T12,? super T13,? super T14,? super T15,? extends R> function) {
        return function.apply(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<R,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> mapAt1(Function<? super T1,? extends R> function) {
        return new Tuple15<>(function.apply(t1),t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,R,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> mapAt2(Function<? super T2,? extends R> function) {
        return new Tuple15<>(t1,function.apply(t2),t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,R,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> mapAt3(Function<? super T3,? extends R> function) {
        return new Tuple15<>(t1,t2,function.apply(t3),t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,R,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> mapAt4(Function<? super T4,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,function.apply(t4),t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,R,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> mapAt5(Function<? super T5,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,function.apply(t5),t6,t7,t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,R,T7,T8,T9,T10,T11,T12,T13,T14,T15> mapAt6(Function<? super T6,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,function.apply(t6),t7,t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,R,T8,T9,T10,T11,T12,T13,T14,T15> mapAt7(Function<? super T7,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,function.apply(t7),t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,R,T9,T10,T11,T12,T13,T14,T15> mapAt8(Function<? super T8,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,function.apply(t8),t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,R,T10,T11,T12,T13,T14,T15> mapAt9(Function<? super T9,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,t8,function.apply(t9),t10,t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,R,T11,T12,T13,T14,T15> mapAt10(Function<? super T10,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,function.apply(t10),t11,t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,R,T12,T13,T14,T15> mapAt11(Function<? super T11,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,function.apply(t11),t12,t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,R,T13,T14,T15> mapAt12(Function<? super T12,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,function.apply(t12),t13,t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,R,T14,T15> mapAt13(Function<? super T13,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,function.apply(t13),t14,t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,R,T15> mapAt14(Function<? super T14,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,function.apply(t14),t15);
    }

    /**
     * Transform an element in this tuple into another object.
     * @param function function that performs the transformation
     * @param <R> return type of transformed element
     * @return a tuple with transformed element.
     */
    public <R> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,R> mapAt15(Function<? super T15,? extends R> function) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,function.apply(t15));
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
     *        .match(all("John","Wellington"), (a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p) -> System.out.println(a))
     *        .match(all("Alex","Wall",23), (a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p) -> System.out.println(b))
     * }
     * </pre>
     * @param matcher object to use with this tuple.
     * @param consumer function to execute if match is found.
     * @param <Q> type of matcher.
     * @return this tuple -- useful for multiple matches.
     */
    public <Q extends Matcher> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> match(final Q matcher, final Consumer15<? super T1,? super T2,? super T3,? super T4,? super T5,? super T6,? super T7,? super T8,? super T9,? super T10,? super T11,? super T12,? super T13,? super T14,? super T15> consumer) {
        Objects.requireNonNull(consumer);
        Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> result = this;
        if (matcher.match(this))
            consumer.accept(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15);

        return result;
    }

    /**
     * Remove element at position 1
     */
    public Tuple14<T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> removeAt1() {
        return remove(1);
    }

    /**
     * Remove element at position 2
     */
    public Tuple14<T1,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> removeAt2() {
        return remove(2);
    }

    /**
     * Remove element at position 3
     */
    public Tuple14<T1,T2,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> removeAt3() {
        return remove(3);
    }

    /**
     * Remove element at position 4
     */
    public Tuple14<T1,T2,T3,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> removeAt4() {
        return remove(4);
    }

    /**
     * Remove element at position 5
     */
    public Tuple14<T1,T2,T3,T4,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> removeAt5() {
        return remove(5);
    }

    /**
     * Remove element at position 6
     */
    public Tuple14<T1,T2,T3,T4,T5,T7,T8,T9,T10,T11,T12,T13,T14,T15> removeAt6() {
        return remove(6);
    }

    /**
     * Remove element at position 7
     */
    public Tuple14<T1,T2,T3,T4,T5,T6,T8,T9,T10,T11,T12,T13,T14,T15> removeAt7() {
        return remove(7);
    }

    /**
     * Remove element at position 8
     */
    public Tuple14<T1,T2,T3,T4,T5,T6,T7,T9,T10,T11,T12,T13,T14,T15> removeAt8() {
        return remove(8);
    }

    /**
     * Remove element at position 9
     */
    public Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T10,T11,T12,T13,T14,T15> removeAt9() {
        return remove(9);
    }

    /**
     * Remove element at position 10
     */
    public Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T9,T11,T12,T13,T14,T15> removeAt10() {
        return remove(10);
    }

    /**
     * Remove element at position 11
     */
    public Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T12,T13,T14,T15> removeAt11() {
        return remove(11);
    }

    /**
     * Remove element at position 12
     */
    public Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T13,T14,T15> removeAt12() {
        return remove(12);
    }

    /**
     * Remove element at position 13
     */
    public Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T14,T15> removeAt13() {
        return remove(13);
    }

    /**
     * Remove element at position 14
     */
    public Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T15> removeAt14() {
        return remove(14);
    }

    /**
     * Remove element at position 15
     */
    public Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> removeAt15() {
        return remove(15);
    }

    /**
     * Rotates this tuple 1 time to the right
     */
    public Tuple15<T15,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> rotateRight1() {
        return rotateRight(1);
    }

    /**
     * Rotates this tuple 2 times to the right
     */
    public Tuple15<T14,T15,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13> rotateRight2() {
        return rotateRight(2);
    }

    /**
     * Rotates this tuple 3 times to the right
     */
    public Tuple15<T13,T14,T15,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> rotateRight3() {
        return rotateRight(3);
    }

    /**
     * Rotates this tuple 4 times to the right
     */
    public Tuple15<T12,T13,T14,T15,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11> rotateRight4() {
        return rotateRight(4);
    }

    /**
     * Rotates this tuple 5 times to the right
     */
    public Tuple15<T11,T12,T13,T14,T15,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10> rotateRight5() {
        return rotateRight(5);
    }

    /**
     * Rotates this tuple 6 times to the right
     */
    public Tuple15<T10,T11,T12,T13,T14,T15,T1,T2,T3,T4,T5,T6,T7,T8,T9> rotateRight6() {
        return rotateRight(6);
    }

    /**
     * Rotates this tuple 7 times to the right
     */
    public Tuple15<T9,T10,T11,T12,T13,T14,T15,T1,T2,T3,T4,T5,T6,T7,T8> rotateRight7() {
        return rotateRight(7);
    }

    /**
     * Rotates this tuple 8 times to the right
     */
    public Tuple15<T8,T9,T10,T11,T12,T13,T14,T15,T1,T2,T3,T4,T5,T6,T7> rotateRight8() {
        return rotateRight(8);
    }

    /**
     * Rotates this tuple 9 times to the right
     */
    public Tuple15<T7,T8,T9,T10,T11,T12,T13,T14,T15,T1,T2,T3,T4,T5,T6> rotateRight9() {
        return rotateRight(9);
    }

    /**
     * Rotates this tuple 10 times to the right
     */
    public Tuple15<T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T1,T2,T3,T4,T5> rotateRight10() {
        return rotateRight(10);
    }

    /**
     * Rotates this tuple 11 times to the right
     */
    public Tuple15<T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T1,T2,T3,T4> rotateRight11() {
        return rotateRight(11);
    }

    /**
     * Rotates this tuple 12 times to the right
     */
    public Tuple15<T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T1,T2,T3> rotateRight12() {
        return rotateRight(12);
    }

    /**
     * Rotates this tuple 13 times to the right
     */
    public Tuple15<T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T1,T2> rotateRight13() {
        return rotateRight(13);
    }

    /**
     * Rotates this tuple 14 times to the right
     */
    public Tuple15<T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T1> rotateRight14() {
        return rotateRight(14);
    }

    /**
     * Rotates this tuple 1 time to the left
     */
    public Tuple15<T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T1> rotateLeft1() {
        return rotateLeft(1);
    }

    /**
     * Rotates this tuple 2 times to the left
     */
    public Tuple15<T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T1,T2> rotateLeft2() {
        return rotateLeft(2);
    }

    /**
     * Rotates this tuple 3 times to the left
     */
    public Tuple15<T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T1,T2,T3> rotateLeft3() {
        return rotateLeft(3);
    }

    /**
     * Rotates this tuple 4 times to the left
     */
    public Tuple15<T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T1,T2,T3,T4> rotateLeft4() {
        return rotateLeft(4);
    }

    /**
     * Rotates this tuple 5 times to the left
     */
    public Tuple15<T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T1,T2,T3,T4,T5> rotateLeft5() {
        return rotateLeft(5);
    }

    /**
     * Rotates this tuple 6 times to the left
     */
    public Tuple15<T7,T8,T9,T10,T11,T12,T13,T14,T15,T1,T2,T3,T4,T5,T6> rotateLeft6() {
        return rotateLeft(6);
    }

    /**
     * Rotates this tuple 7 times to the left
     */
    public Tuple15<T8,T9,T10,T11,T12,T13,T14,T15,T1,T2,T3,T4,T5,T6,T7> rotateLeft7() {
        return rotateLeft(7);
    }

    /**
     * Rotates this tuple 8 times to the left
     */
    public Tuple15<T9,T10,T11,T12,T13,T14,T15,T1,T2,T3,T4,T5,T6,T7,T8> rotateLeft8() {
        return rotateLeft(8);
    }

    /**
     * Rotates this tuple 9 times to the left
     */
    public Tuple15<T10,T11,T12,T13,T14,T15,T1,T2,T3,T4,T5,T6,T7,T8,T9> rotateLeft9() {
        return rotateLeft(9);
    }

    /**
     * Rotates this tuple 10 times to the left
     */
    public Tuple15<T11,T12,T13,T14,T15,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10> rotateLeft10() {
        return rotateLeft(10);
    }

    /**
     * Rotates this tuple 11 times to the left
     */
    public Tuple15<T12,T13,T14,T15,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11> rotateLeft11() {
        return rotateLeft(11);
    }

    /**
     * Rotates this tuple 12 times to the left
     */
    public Tuple15<T13,T14,T15,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> rotateLeft12() {
        return rotateLeft(12);
    }

    /**
     * Rotates this tuple 13 times to the left
     */
    public Tuple15<T14,T15,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13> rotateLeft13() {
        return rotateLeft(13);
    }

    /**
     * Rotates this tuple 14 times to the left
     */
    public Tuple15<T15,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> rotateLeft14() {
        return rotateLeft(14);
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

    /**
     * Truncates tuples at position 7
     */
    public Tuple6<T1,T2,T3,T4,T5,T6> truncateAt7() {
        return truncate(7);
    }

    /**
     * Truncates tuples at position 8
     */
    public Tuple7<T1,T2,T3,T4,T5,T6,T7> truncateAt8() {
        return truncate(8);
    }

    /**
     * Truncates tuples at position 9
     */
    public Tuple8<T1,T2,T3,T4,T5,T6,T7,T8> truncateAt9() {
        return truncate(9);
    }

    /**
     * Truncates tuples at position 10
     */
    public Tuple9<T1,T2,T3,T4,T5,T6,T7,T8,T9> truncateAt10() {
        return truncate(10);
    }

    /**
     * Truncates tuples at position 11
     */
    public Tuple10<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10> truncateAt11() {
        return truncate(11);
    }

    /**
     * Truncates tuples at position 12
     */
    public Tuple11<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11> truncateAt12() {
        return truncate(12);
    }

    /**
     * Truncates tuples at position 13
     */
    public Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> truncateAt13() {
        return truncate(13);
    }

    /**
     * Truncates tuples at position 14
     */
    public Tuple13<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13> truncateAt14() {
        return truncate(14);
    }

    /**
     * Truncates tuples at position 15
     */
    public Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> truncateAt15() {
        return truncate(15);
    }

}
