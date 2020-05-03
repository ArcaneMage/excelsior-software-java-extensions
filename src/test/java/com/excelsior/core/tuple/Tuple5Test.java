package com.excelsior.core.tuple;

import com.excelsior.core.Nullable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tuple5Test {

    private Tuple5<Integer,Integer,Integer,Integer,Integer> tuple;

    @BeforeEach
    public void setup() {
        tuple = Tuple.of(1,2,3,4,5);
    }

    @Test
    public void testValue_Pass() {
        assertEquals(1,tuple.value1());
        assertEquals(2,tuple.value2());
        assertEquals(3,tuple.value3());
        assertEquals(4,tuple.value4());
        assertEquals(5,tuple.value5());
    }

    @Test
    public void testAddAt_Pass() {
        Tuple6 tuple6 = tuple.addAt1("a");
        assertEquals(Tuple.of("a",1,2,3,4,5),tuple6);

        tuple6 = tuple.addAt2("a");
        assertEquals(Tuple.of(1,"a",2,3,4,5),tuple6);

        tuple6 = tuple.addAt3("a");
        assertEquals(Tuple.of(1,2,"a",3,4,5),tuple6);

        tuple6 = tuple.addAt4("a");
        assertEquals(Tuple.of(1,2,3,"a",4,5),tuple6);

        tuple6 = tuple.addAt5("a");
        assertEquals(Tuple.of(1,2,3,4,"a",5),tuple6);
    }

    @Test
    public void testHopTo_Pass() {
        Tuple5 tuple5 = tuple.hopTo1();
        assertEquals(Tuple.of(1,2,3,4,5), tuple5);

        Tuple4 tuple4 = tuple.hopTo2();
        assertEquals(Tuple.of(2,3,4,5), tuple4);

        Tuple3 tuple3 = tuple.hopTo3();
        assertEquals(Tuple.of(3,4,5), tuple3);

        Tuple2 tuple2 = tuple.hopTo4();
        assertEquals(Tuple.of(4,5), tuple2);

        Tuple1 tuple1 = tuple.hopTo5();
        assertEquals(Tuple.of(5), tuple1);
    }

    @Test
    public void testJoin_Pass() {
        Tuple5 aTuple5 = tuple.join(Tuple.of());
        assertEquals(Tuple.of(1,2,3,4,5),aTuple5);

        Tuple6 aTuple6_1 = tuple.join("end-of-tuple");
        assertEquals("end-of-tuple",aTuple6_1.value6());

        Tuple6 aTuple6_2 = tuple.join(Tuple.of(6));
        assertEquals(Tuple.of(1,2,3,4,5,6),aTuple6_2);

        Tuple7 aTuple7 = tuple.join(Tuple.of(6,7));
        assertEquals(Tuple.of(1,2,3,4,5,6,7),aTuple7);

        Tuple8 aTuple8 = tuple.join(Tuple.of(6,7,8));
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8),aTuple8);

        Tuple9 aTuple9 = tuple.join(Tuple.of(6,7,8,9));
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9),aTuple9);

        Tuple10 aTuple10 = tuple.join(Tuple.of(6,7,8,9,10));
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10),aTuple10);

        Tuple11 aTuple11 = tuple.join(Tuple.of(6,7,8,9,10,11));
        assertEquals(aTuple11,Tuple.of(1,2,3,4,5,6,7,8,9,10,11));

        Tuple12 aTuple12 = tuple.join(Tuple.of(6,7,8,9,10,11,12));
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12),aTuple12);

        Tuple13 aTuple13 = tuple.join(Tuple.of(6,7,8,9,10,11,12,13));
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13),aTuple13);

        Tuple14 aTuple14 = tuple.join(Tuple.of(6,7,8,9,10,11,12,13,14));
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14),aTuple14);

        Tuple15 aTuple15 = tuple.join(Tuple.of(6,7,8,9,10,11,12,13,14,15));
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15),aTuple15);

        Tuple16 aTuple16 = tuple.join(Tuple.of(6,7,8,9,10,11,12,13,14,15,16));
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16),aTuple16);
    }


    @Test
    public void testFromIterable_Pass() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        Nullable<Tuple5<Integer, Integer, Integer, Integer, Integer>>
                maybeTuple = Tuple5.fromIterable(list);

        maybeTuple.ifPresentOrElse(tuple -> assertEquals(Tuple.of(1,2,3,4,5), tuple),
                Assertions::fail);

        list = Arrays.asList(1);
        maybeTuple = Tuple5.fromIterable(list);

        assertTrue(maybeTuple.isEmpty());
    }

    @Test
    public void testSpliceAt_Pass() {
        Tuple2<Tuple0,Tuple5<Integer,Integer,Integer,Integer,Integer>>
                spliced1 = tuple.spliceAt1();
        assertEquals(2, spliced1.depth());
        assertEquals(0, spliced1.value1().depth());
        assertEquals(5, spliced1.value2().value5());

        Tuple2<Tuple1<Integer>,Tuple4<Integer,Integer,Integer,Integer>>
                spliced2 = tuple.spliceAt2();
        assertEquals(2, spliced2.depth());
        assertEquals(1, spliced2.value1().value1());
        assertEquals(5, spliced2.value2().value4());

        Tuple2<Tuple2<Integer,Integer>,Tuple3<Integer,Integer,Integer>>
                spliced3 = tuple.spliceAt3();
        assertEquals(2, spliced3.depth());
        assertEquals(1, spliced3.value1().value1());
        assertEquals(5, spliced3.value2().value3());

        Tuple2<Tuple3<Integer,Integer,Integer>,Tuple2<Integer,Integer>>
                spliced4 = tuple.spliceAt4();
        assertEquals(2, spliced4.depth());
        assertEquals(1, spliced4.value1().value1());
        assertEquals(5, spliced4.value2().value2());

        Tuple2<Tuple4<Integer,Integer,Integer,Integer>,Tuple1<Integer>>
                spliced5 = tuple.spliceAt5();
        assertEquals(2, spliced5.depth());
        assertEquals(1, spliced5.value1().value1());
        assertEquals(5, spliced5.value2().value1());
    }

    @Test
    public void testRemove_Pass() {
        Tuple4 tuple4 = tuple.remove(5);
        assertEquals(Tuple.of(1,2,3,4),tuple4);

        Tuple4 tuple4_2 = tuple.remove(2);
        assertEquals(Tuple.of(1,3,4,5),tuple4_2);

        Tuple4 tuple4_3 = tuple.remove(1);
        assertEquals(Tuple.of(2,3,4,5),tuple4_3);
    }

    @Test
    public void testTruncateAt_Pass() {
        Tuple0 aTuple0 = tuple.truncateAt1();
        assertEquals(Tuple.of(),aTuple0);

        Tuple1 aTuple1 = tuple.truncateAt2();
        assertEquals(Tuple.of(1),aTuple1);

        Tuple2 aTuple2 = tuple.truncateAt3();
        assertEquals(Tuple.of(1,2),aTuple2);

        Tuple3 aTuple3 = tuple.truncateAt4();
        assertEquals(Tuple.of(1,2,3),aTuple3);

        Tuple4 aTuple4 = tuple.truncateAt5();
        assertEquals(Tuple.of(1,2,3,4),aTuple4);
    }

    @Test
    public void testTestTransform_Pass() {
        Tuple5 aTuple5;

        aTuple5 = tuple.transform1(a -> 0);
        assertEquals(Tuple.of(0,2,3,4,5),aTuple5);

        aTuple5 = tuple.transform2(a -> 0);
        assertEquals(Tuple.of(1,0,3,4,5),aTuple5);

        aTuple5 = tuple.transform3(a -> 0);
        assertEquals(Tuple.of(1,2,0,4,5),aTuple5);

        aTuple5 = tuple.transform4(a -> 0);
        assertEquals(Tuple.of(1,2,3,0,5),aTuple5);

        aTuple5 = tuple.transform5(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,0),aTuple5);
    }
}
