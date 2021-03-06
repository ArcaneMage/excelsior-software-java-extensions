package org.javalaboratories.core.tuple;
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

import java.util.*;

/**
 * A tuple implements this interface.
 * <p>
 * A tuple is a container whose elements are NOT necessarily of the same type.
 * However, they are powerful in that they provide a mechanism for functions
 * to return multiple values and/or pass multiple values as single tuple
 * method argument. They do not always relate to each other but collectively
 * they have some meaning.
 * <p>
 * Up to 16 tuple types are currently supported and are created with the aid of
 * factory methods, {@link Tuple#of}, defined in this interface. There are many
 * operations available on tuples including the ability to convert elements to
 * to a {@link List}, {@link Map} and to an array.
 * <p>
 * All tuples are immutable, comparable, iterable and serializable.
 * @see Tuple0
 * @see Tuple1
 * @see Tuple2
 * @see Tuple3
 * @see Tuple4
 * @see Tuple5
 * @see Tuple6
 * @see Tuple7
 * @see Tuple8
 * @see Tuple9
 * @see Tuple10
 * @see Tuple11
 * @see Tuple12
 * @see Tuple13
 * @see Tuple14
 * @see Tuple15
 * @see Tuple16
 *
 * @author Kevin Henry
 */
public interface Tuple extends TupleContainer, JoinableTuple<Tuple> {
    /**
     * Creates a tuple with a depth of 0
     * @return a tuple of encapsulating the element(s)
     */
    static Tuple0 of() { return new Tuple0(); }

    /**
     * Creates a tuple with a depth of 1
     * @return a tuple of encapsulating the element(s)
     */
    static <T1> Tuple1<T1> of(T1 t1) {
        return new Tuple1<>(t1);
    }

    /**
     * Creates a tuple with a depth of 2
     * @return a tuple of encapsulating the element(s)
     */
    static <T1,T2> Tuple2<T1,T2> of(T1 t1, T2 t2) {
        return new Tuple2<>(t1,t2);
    }

    /**
     * Creates a tuple with a depth of 3
     * @return a tuple of encapsulating the element(s)
     */
    static <T1,T2,T3> Tuple3<T1,T2,T3> of(T1 t1, T2 t2, T3 t3) {
        return new Tuple3<>(t1,t2,t3);
    }

    /**
     * Creates a tuple with a depth of 4
     * @return a tuple of encapsulating the element(s)
     */
    static <T1,T2,T3,T4> Tuple4<T1,T2,T3,T4> of(T1 t1, T2 t2, T3 t3, T4 t4) {
        return new Tuple4<>(t1,t2,t3,t4);
    }

    /**
     * Creates a tuple with a depth of 5
     * @return a tuple of encapsulating the element(s)
     */
    static <T1,T2,T3,T4,T5> Tuple5<T1,T2,T3,T4,T5> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        return new Tuple5<>(t1,t2,t3,t4,t5);
    }

    /**
     * Creates a tuple with a depth of 6
     * @return a tuple of encapsulating the element(s)
     */
    static <T1,T2,T3,T4,T5,T6> Tuple6<T1,T2,T3,T4,T5,T6> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        return new Tuple6<>(t1,t2,t3,t4,t5,t6);
    }

    /**
     * Creates a tuple with a depth of 7
     * @return a tuple of encapsulating the element(s)
     */
    static <T1,T2,T3,T4,T5,T6,T7> Tuple7<T1,T2,T3,T4,T5,T6,T7> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        return new Tuple7<>(t1,t2,t3,t4,t5,t6,t7);
    }

    /**
     * Creates a tuple with a depth of 8
     * @return a tuple of encapsulating the element(s)
     */
    static <T1,T2,T3,T4,T5,T6,T7,T8> Tuple8<T1,T2,T3,T4,T5,T6,T7,T8> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        return new Tuple8<>(t1,t2,t3,t4,t5,t6,t7,t8);
    }

    /**
     * Creates a tuple with a depth of 9
     * @return a tuple of encapsulating the element(s)
     */
    static <T1,T2,T3,T4,T5,T6,T7,T8,T9> Tuple9<T1,T2,T3,T4,T5,T6,T7,T8,T9> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
        return new Tuple9<>(t1,t2,t3,t4,t5,t6,t7,t8,t9);
    }

    /**
     * Creates a tuple with a depth of 10
     * @return a tuple of encapsulating the element(s)
     */
    static <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10> Tuple10<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10) {
        return new Tuple10<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10);
    }

    /**
     * Creates a tuple with a depth of 11
     * @return a tuple of encapsulating the element(s)
     */
    static <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11> Tuple11<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11) {
        return new Tuple11<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11);
    }

    /**
     * Creates a tuple with a depth of 12
     * @return a tuple of encapsulating the element(s)
     */
    static <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> Tuple12<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12) {
        return new Tuple12<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12);
    }

    /**
     * Creates a tuple with a depth of 13
     * @return a tuple of encapsulating the element(s)
     */
    static <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13> Tuple13<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13) {
        return new Tuple13<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13);
    }

    /**
     * Creates a tuple with a depth of 14
     * @return a tuple of encapsulating the element(s)
     */
    static <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> Tuple14<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14) {
        return new Tuple14<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14);
    }

    /**
     * Creates a tuple with a depth of 15
     * @return a tuple of encapsulating the element(s)
     */
    static <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> Tuple15<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15) {
        return new Tuple15<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15);
    }

    /**
     * Creates a tuple with a depth of 16
     * @return a tuple of encapsulating the element(s)
     */
    static <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> Tuple16<T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> of(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15, T16 t16) {
        return new Tuple16<>(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16);
    }

}