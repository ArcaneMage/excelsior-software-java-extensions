package com.excelsior.core.tuple;

import com.excelsior.core.Nullable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tuple7Test {

    private Tuple7<Integer,Integer,Integer,Integer,Integer,Integer,Integer> tuple;

    @BeforeEach
    public void setup() {
        tuple = Tuple.of(1,2,3,4,5,6,7);
    }

    @Test
    public void testValue_Pass() {
        assertEquals(1,tuple.value1());
        assertEquals(2,tuple.value2());
        assertEquals(3,tuple.value3());
        assertEquals(4,tuple.value4());
        assertEquals(5,tuple.value5());
        assertEquals(6,tuple.value6());
        assertEquals(7,tuple.value7());
    }

    @Test
    public void testJoin_Pass() {
        Tuple8 aTuple8_1 = tuple.join("end-of-tuple");
        assertEquals("end-of-tuple",aTuple8_1.value8());

        Tuple8 aTuple8_2 = tuple.join(Tuple.of(8));
        assertEquals(aTuple8_2,Tuple.of(1,2,3,4,5,6,7,8));

        Tuple9 aTuple9 = tuple.join(Tuple.of(8,9));
        assertEquals(aTuple9,Tuple.of(1,2,3,4,5,6,7,8,9));

        Tuple10 aTuple10 = tuple.join(Tuple.of(8,9,10));
        assertEquals(aTuple10,Tuple.of(1,2,3,4,5,6,7,8,9,10));

        Tuple11 aTuple11 = tuple.join(Tuple.of(8,9,10,11));
        assertEquals(aTuple11,Tuple.of(1,2,3,4,5,6,7,8,9,10,11));

        Tuple12 aTuple12 = tuple.join(Tuple.of(8,9,10,11,12));
        assertEquals(aTuple12,Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12));

        Tuple13 aTuple13 = tuple.join(Tuple.of(8,9,10,11,12,13));
        assertEquals(aTuple13,Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13));

        Tuple14 aTuple14 = tuple.join(Tuple.of(8,9,10,11,12,13,14));
        assertEquals(aTuple14,Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14));

        Tuple15 aTuple15 = tuple.join(Tuple.of(8,9,10,11,12,13,14,15));
        assertEquals(aTuple15,Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));

        Tuple16 aTuple16 = tuple.join(Tuple.of(8,9,10,11,12,13,14,15,16));
        assertEquals(aTuple16,Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16));
    }

    @Test
    public void testFromIterable_Pass() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);

        Nullable<Tuple7<Integer, Integer, Integer, Integer, Integer, Integer, Integer>>
                maybeTuple = Tuple7.fromIterable(list);

        maybeTuple.ifPresentOrElse(tuple -> assertEquals(Tuple.of(1,2,3,4,5,6,7), tuple),
                Assertions::fail);

        list = Arrays.asList(1);
        maybeTuple = Tuple7.fromIterable(list);

        assertTrue(maybeTuple.isEmpty());
    }

    @Test
    public void testSplice_Pass() {
        Tuple2<Tuple1<Integer>,Tuple6<Integer,Integer,Integer,Integer,Integer,Integer>>
                spliced1 = tuple.splice1();
        assertEquals(2, spliced1.depth());
        assertEquals(1, spliced1.value1().value1());
        assertEquals(7, spliced1.value2().value6());

        Tuple2<Tuple2<Integer,Integer>,Tuple5<Integer,Integer,Integer,Integer,Integer>>
                spliced2 = tuple.splice2();
        assertEquals(2, spliced2.depth());
        assertEquals(1, spliced2.value1().value1());
        assertEquals(7, spliced2.value2().value5());

        Tuple2<Tuple3<Integer,Integer,Integer>,Tuple4<Integer,Integer,Integer,Integer>>
                spliced3 = tuple.splice3();
        assertEquals(2, spliced3.depth());
        assertEquals(1, spliced3.value1().value1());
        assertEquals(7, spliced3.value2().value4());

        Tuple2<Tuple4<Integer,Integer,Integer,Integer>,Tuple3<Integer,Integer,Integer>>
                spliced4 = tuple.splice4();
        assertEquals(2, spliced4.depth());
        assertEquals(1, spliced4.value1().value1());
        assertEquals(7, spliced4.value2().value3());

        Tuple2<Tuple5<Integer,Integer,Integer,Integer,Integer>,Tuple2<Integer,Integer>>
                spliced5 = tuple.splice5();
        assertEquals(2, spliced5.depth());
        assertEquals(1, spliced5.value1().value1());
        assertEquals(7, spliced5.value2().value2());

        Tuple2<Tuple6<Integer,Integer,Integer,Integer,Integer,Integer>,Tuple1<Integer>>
                spliced6 = tuple.splice6();
        assertEquals(2, spliced6.depth());
        assertEquals(1, spliced6.value1().value1());
        assertEquals(7, spliced6.value2().value1());
    }

    @Test
    public void testTruncate_Pass() {
        Tuple1 aTuple1 = tuple.truncate1();
        assertEquals(Tuple.of(1),aTuple1);

        Tuple2 aTuple2 = tuple.truncate2();
        assertEquals(Tuple.of(1,2),aTuple2);

        Tuple3 aTuple3 = tuple.truncate3();
        assertEquals(Tuple.of(1,2,3),aTuple3);

        Tuple4 aTuple4 = tuple.truncate4();
        assertEquals(Tuple.of(1,2,3,4),aTuple4);

        Tuple5 aTuple5 = tuple.truncate5();
        assertEquals(Tuple.of(1,2,3,4,5),aTuple5);

        Tuple6 aTuple6 = tuple.truncate6();
        assertEquals(Tuple.of(1,2,3,4,5,6),aTuple6);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testTestTransform_Pass() {
        Tuple7 aTuple7;

        aTuple7 = tuple.transform1(a -> 0);
        assertEquals(Tuple.of(0,2,3,4,5,6,7),aTuple7);

        aTuple7 = tuple.transform2(a -> 0);
        assertEquals(Tuple.of(1,0,3,4,5,6,7),aTuple7);

        aTuple7 = tuple.transform3(a -> 0);
        assertEquals(Tuple.of(1,2,0,4,5,6,7),aTuple7);

        aTuple7 = tuple.transform4(a -> 0);
        assertEquals(Tuple.of(1,2,3,0,5,6,7),aTuple7);

        aTuple7 = tuple.transform5(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,0,6,7),aTuple7);

        aTuple7 = tuple.transform6(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,5,0,7),aTuple7);

        aTuple7 = tuple.transform7(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,5,6,0),aTuple7);
    }
}