package org.javalaboratories.core.tuple;

import org.javalaboratories.core.Maybe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.javalaboratories.core.tuple.Matcher.*;
import static org.junit.jupiter.api.Assertions.*;

public class Tuple16Test {

    private Tuple16<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,
                    Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer> tuple;

    @BeforeEach
    public void setup() {
        tuple = Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
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
        assertEquals(8,tuple.value8());
        assertEquals(9,tuple.value9());
        assertEquals(10,tuple.value10());
        assertEquals(11,tuple.value11());
        assertEquals(12,tuple.value12());
        assertEquals(13,tuple.value13());
        assertEquals(14,tuple.value14());
        assertEquals(15,tuple.value15());
        assertEquals(16,tuple.value16());
    }

    @Test
    public void testAdd_Fail() {
        assertThrows(TupleOverflowException.class, () -> tuple.add(1,"a"));
    }

    @Test
    public void testHopTo_Pass() {
        Tuple16 tuple16 = tuple.hopTo1();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16), tuple16);

        Tuple15 tuple15 = tuple.hopTo2();
        assertEquals(Tuple.of(2,3,4,5,6,7,8,9,10,11,12,13,14,15,16), tuple15);

        Tuple14 tuple14 = tuple.hopTo3();
        assertEquals(Tuple.of(3,4,5,6,7,8,9,10,11,12,13,14,15,16), tuple14);

        Tuple13 tuple13 = tuple.hopTo4();
        assertEquals(Tuple.of(4,5,6,7,8,9,10,11,12,13,14,15,16), tuple13);

        Tuple12 tuple12 = tuple.hopTo5();
        assertEquals(Tuple.of(5,6,7,8,9,10,11,12,13,14,15,16), tuple12);

        Tuple11 tuple11 = tuple.hopTo6();
        assertEquals(Tuple.of(6,7,8,9,10,11,12,13,14,15,16), tuple11);

        Tuple10 tuple10 = tuple.hopTo7();
        assertEquals(Tuple.of(7,8,9,10,11,12,13,14,15,16), tuple10);

        Tuple9 tuple9 = tuple.hopTo8();
        assertEquals(Tuple.of(8,9,10,11,12,13,14,15,16), tuple9);

        Tuple8 tuple8 = tuple.hopTo9();
        assertEquals(Tuple.of(9,10,11,12,13,14,15,16), tuple8);

        Tuple7 tuple7 = tuple.hopTo10();
        assertEquals(Tuple.of(10,11,12,13,14,15,16), tuple7);

        Tuple6 tuple6 = tuple.hopTo11();
        assertEquals(Tuple.of(11,12,13,14,15,16), tuple6);

        Tuple5 tuple5 = tuple.hopTo12();
        assertEquals(Tuple.of(12,13,14,15,16), tuple5);

        Tuple4 tuple4 = tuple.hopTo13();
        assertEquals(Tuple.of(13,14,15,16), tuple4);

        Tuple3 tuple3 = tuple.hopTo14();
        assertEquals(Tuple.of(14,15,16), tuple3);

        Tuple2 tuple2 = tuple.hopTo15();
        assertEquals(Tuple.of(15,16), tuple2);

        Tuple1 tuple1 = tuple.hopTo16();
        assertEquals(Tuple.of(16), tuple1);
    }

    @Test
    public void testJoin_Pass() {
        Tuple16 aTuple16 = tuple.join(Tuple.of());
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16),aTuple16);
    }

    @Test
    public void testFromIterable_Pass() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);

        Maybe<Tuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer,
                                Integer, Integer, Integer, Integer, Integer, Integer>>
                maybeTuple = Tuple16.fromIterable(list);

        maybeTuple.ifPresentOrElse(tuple -> assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16), tuple),
                Assertions::fail);

        list = Arrays.asList(1);
        maybeTuple = Tuple16.fromIterable(list);

        assertTrue(maybeTuple.isEmpty());
    }

    @Test
    public void testSpliceAt_Pass() {
        Tuple2<Tuple0,Tuple16<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer,Integer>> spliced1 = tuple.spliceAt1();
        assertEquals(2, spliced1.depth());
        assertEquals(0, spliced1.value1().depth());
        assertEquals(16, spliced1.value2().value16());

        Tuple2<Tuple1<Integer>,Tuple15<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer,Integer>> spliced2 = tuple.spliceAt2();
        assertEquals(2, spliced2.depth());
        assertEquals(1, spliced2.value1().value1());
        assertEquals(16, spliced2.value2().value15());

        Tuple2<Tuple2<Integer,Integer>,Tuple14<Integer,Integer,Integer,Integer,Integer,Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer,Integer>> spliced3 = tuple.spliceAt3();
        assertEquals(2, spliced3.depth());
        assertEquals(1, spliced3.value1().value1());
        assertEquals(16, spliced3.value2().value14());

        Tuple2<Tuple3<Integer,Integer,Integer>,Tuple13<Integer,Integer,Integer,Integer,Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer,Integer>> spliced4 = tuple.spliceAt4();
        assertEquals(2, spliced4.depth());
        assertEquals(1, spliced4.value1().value1());
        assertEquals(16, spliced4.value2().value13());

        Tuple2<Tuple4<Integer,Integer,Integer,Integer>,Tuple12<Integer,Integer,Integer,Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer,Integer>> spliced5 = tuple.spliceAt5();
        assertEquals(2, spliced5.depth());
        assertEquals(1, spliced5.value1().value1());
        assertEquals(16, spliced5.value2().value12());

        Tuple2<Tuple5<Integer,Integer,Integer,Integer,Integer>,Tuple11<Integer,Integer,Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer,Integer>> spliced6 = tuple.spliceAt6();
        assertEquals(2, spliced6.depth());
        assertEquals(1, spliced6.value1().value1());
        assertEquals(16, spliced6.value2().value11());

        Tuple2<Tuple6<Integer,Integer,Integer,Integer,Integer,Integer>,Tuple10<Integer,Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer,Integer>> spliced7 = tuple.spliceAt7();
        assertEquals(2, spliced7.depth());
        assertEquals(1, spliced7.value1().value1());
        assertEquals(16, spliced7.value2().value10());

        Tuple2<Tuple7<Integer,Integer,Integer,Integer,Integer,Integer,Integer>,Tuple9<Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer,Integer>> spliced8 = tuple.spliceAt8();
        assertEquals(2, spliced8.depth());
        assertEquals(1, spliced8.value1().value1());
        assertEquals(16, spliced8.value2().value9());

        Tuple2<Tuple8<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer>,Tuple8<Integer,
                Integer,Integer,Integer,Integer,Integer,Integer,Integer>> spliced9 = tuple.spliceAt9();
        assertEquals(2, spliced9.depth());
        assertEquals(1, spliced9.value1().value1());
        assertEquals(16, spliced9.value2().value8());

        Tuple2<Tuple9<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer>,
                Tuple7<Integer,Integer,Integer,Integer,Integer,Integer,Integer>> spliced10 = tuple.spliceAt10();
        assertEquals(2, spliced10.depth());
        assertEquals(1, spliced10.value1().value1());
        assertEquals(16, spliced10.value2().value7());

        Tuple2<Tuple10<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer>,
                Tuple6<Integer,Integer,Integer,Integer,Integer,Integer>> spliced11 = tuple.spliceAt11();
        assertEquals(2, spliced11.depth());
        assertEquals(1, spliced11.value1().value1());
        assertEquals(16, spliced11.value2().value6());

        Tuple2<Tuple11<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer>,
                Tuple5<Integer,Integer,Integer,Integer,Integer>> spliced12 = tuple.spliceAt12();
        assertEquals(2, spliced12.depth());
        assertEquals(1, spliced12.value1().value1());
        assertEquals(16, spliced12.value2().value5());

        Tuple2<Tuple12<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer>,
                Tuple4<Integer,Integer,Integer,Integer>> spliced13 = tuple.spliceAt13();
        assertEquals(2, spliced13.depth());
        assertEquals(1, spliced13.value1().value1());
        assertEquals(16, spliced13.value2().value4());

        Tuple2<Tuple13<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer>,
                Tuple3<Integer,Integer,Integer>> spliced14 = tuple.spliceAt14();
        assertEquals(2, spliced14.depth());
        assertEquals(1, spliced14.value1().value1());
        assertEquals(16, spliced14.value2().value3());

        Tuple2<Tuple14<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer>,
                Tuple2<Integer,Integer>> spliced15 = tuple.spliceAt15();
        assertEquals(2, spliced15.depth());
        assertEquals(1, spliced15.value1().value1());
        assertEquals(16, spliced15.value2().value2());

        Tuple2<Tuple15<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer>,
                Tuple1<Integer>> spliced16 = tuple.spliceAt16();
        assertEquals(2, spliced16.depth());
        assertEquals(1, spliced16.value1().value1());
        assertEquals(16, spliced16.value2().value1());
    }

    @Test
    public void testRemove_Pass() {
        Tuple15 tuple15 = tuple.removeAt1();
        assertEquals(Tuple.of(2,3,4,5,6,7,8,9,10,11,12,13,14,15,16),tuple15);

        tuple15 = tuple.removeAt2();
        assertEquals(Tuple.of(1,3,4,5,6,7,8,9,10,11,12,13,14,15,16),tuple15);

        tuple15 = tuple.removeAt3();
        assertEquals(Tuple.of(1,2,4,5,6,7,8,9,10,11,12,13,14,15,16),tuple15);

        tuple15 = tuple.removeAt4();
        assertEquals(Tuple.of(1,2,3,5,6,7,8,9,10,11,12,13,14,15,16),tuple15);

        tuple15 = tuple.removeAt5();
        assertEquals(Tuple.of(1,2,3,4,6,7,8,9,10,11,12,13,14,15,16),tuple15);

        tuple15 = tuple.removeAt6();
        assertEquals(Tuple.of(1,2,3,4,5,7,8,9,10,11,12,13,14,15,16),tuple15);

        tuple15 = tuple.removeAt7();
        assertEquals(Tuple.of(1,2,3,4,5,6,8,9,10,11,12,13,14,15,16),tuple15);

        tuple15 = tuple.removeAt8();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,9,10,11,12,13,14,15,16),tuple15);

        tuple15 = tuple.removeAt9();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,10,11,12,13,14,15,16),tuple15);

        tuple15 = tuple.removeAt10();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,11,12,13,14,15,16),tuple15);

        tuple15 = tuple.removeAt11();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,12,13,14,15,16),tuple15);

        tuple15 = tuple.removeAt12();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,13,14,15,16),tuple15);

        tuple15 = tuple.removeAt13();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,14,15,16),tuple15);

        tuple15 = tuple.removeAt14();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,15,16),tuple15);

        tuple15 = tuple.removeAt15();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,16),tuple15);

        tuple15 = tuple.removeAt16();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15),tuple15);
    }

    @Test
    public void testRotateRight_Pass() {
        Tuple16 tuple16 = tuple.rotateRight1();
        assertEquals(Tuple.of(16,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15),tuple16);

        tuple16 = tuple.rotateRight2();
        assertEquals(Tuple.of(15,16,1,2,3,4,5,6,7,8,9,10,11,12,13,14),tuple16);

        tuple16 = tuple.rotateRight3();
        assertEquals(Tuple.of(14,15,16,1,2,3,4,5,6,7,8,9,10,11,12,13),tuple16);

        tuple16 = tuple.rotateRight4();
        assertEquals(Tuple.of(13,14,15,16,1,2,3,4,5,6,7,8,9,10,11,12),tuple16);

        tuple16 = tuple.rotateRight5();
        assertEquals(Tuple.of(12,13,14,15,16,1,2,3,4,5,6,7,8,9,10,11),tuple16);

        tuple16 = tuple.rotateRight6();
        assertEquals(Tuple.of(11,12,13,14,15,16,1,2,3,4,5,6,7,8,9,10),tuple16);

        tuple16 = tuple.rotateRight7();
        assertEquals(Tuple.of(10,11,12,13,14,15,16,1,2,3,4,5,6,7,8,9),tuple16);

        tuple16 = tuple.rotateRight8();
        assertEquals(Tuple.of(9,10,11,12,13,14,15,16,1,2,3,4,5,6,7,8),tuple16);

        tuple16 = tuple.rotateRight9();
        assertEquals(Tuple.of(8,9,10,11,12,13,14,15,16,1,2,3,4,5,6,7),tuple16);

        tuple16 = tuple.rotateRight10();
        assertEquals(Tuple.of(7,8,9,10,11,12,13,14,15,16,1,2,3,4,5,6),tuple16);

        tuple16 = tuple.rotateRight11();
        assertEquals(Tuple.of(6,7,8,9,10,11,12,13,14,15,16,1,2,3,4,5),tuple16);

        tuple16 = tuple.rotateRight12();
        assertEquals(Tuple.of(5,6,7,8,9,10,11,12,13,14,15,16,1,2,3,4),tuple16);

        tuple16 = tuple.rotateRight13();
        assertEquals(Tuple.of(4,5,6,7,8,9,10,11,12,13,14,15,16,1,2,3),tuple16);

        tuple16 = tuple.rotateRight14();
        assertEquals(Tuple.of(3,4,5,6,7,8,9,10,11,12,13,14,15,16,1,2),tuple16);

        tuple16 = tuple.rotateRight15();
        assertEquals(Tuple.of(2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,1),tuple16);
    }

    @Test
    public void testRotateLeft_Pass() {
        Tuple16 tuple16 = tuple.rotateLeft1();
        assertEquals(Tuple.of(2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,1),tuple16);

        tuple16 = tuple.rotateLeft2();
        assertEquals(Tuple.of(3,4,5,6,7,8,9,10,11,12,13,14,15,16,1,2),tuple16);

        tuple16 = tuple.rotateLeft3();
        assertEquals(Tuple.of(4,5,6,7,8,9,10,11,12,13,14,15,16,1,2,3),tuple16);

        tuple16 = tuple.rotateLeft4();
        assertEquals(Tuple.of(5,6,7,8,9,10,11,12,13,14,15,16,1,2,3,4),tuple16);

        tuple16 = tuple.rotateLeft5();
        assertEquals(Tuple.of(6,7,8,9,10,11,12,13,14,15,16,1,2,3,4,5),tuple16);

        tuple16 = tuple.rotateLeft6();
        assertEquals(Tuple.of(7,8,9,10,11,12,13,14,15,16,1,2,3,4,5,6),tuple16);

        tuple16 = tuple.rotateLeft7();
        assertEquals(Tuple.of(8,9,10,11,12,13,14,15,16,1,2,3,4,5,6,7),tuple16);

        tuple16 = tuple.rotateLeft8();
        assertEquals(Tuple.of(9,10,11,12,13,14,15,16,1,2,3,4,5,6,7,8),tuple16);

        tuple16 = tuple.rotateLeft9();
        assertEquals(Tuple.of(10,11,12,13,14,15,16,1,2,3,4,5,6,7,8,9),tuple16);

        tuple16 = tuple.rotateLeft10();
        assertEquals(Tuple.of(11,12,13,14,15,16,1,2,3,4,5,6,7,8,9,10),tuple16);

        tuple16 = tuple.rotateLeft11();
        assertEquals(Tuple.of(12,13,14,15,16,1,2,3,4,5,6,7,8,9,10,11),tuple16);

        tuple16 = tuple.rotateLeft12();
        assertEquals(Tuple.of(13,14,15,16,1,2,3,4,5,6,7,8,9,10,11,12),tuple16);

        tuple16 = tuple.rotateLeft13();
        assertEquals(Tuple.of(14,15,16,1,2,3,4,5,6,7,8,9,10,11,12,13),tuple16);

        tuple16 = tuple.rotateLeft14();
        assertEquals(Tuple.of(15,16,1,2,3,4,5,6,7,8,9,10,11,12,13,14),tuple16);

        tuple16 = tuple.rotateLeft15();
        assertEquals(Tuple.of(16,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15),tuple16);
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

        Tuple5 aTuple5 = tuple.truncateAt6();
        assertEquals(Tuple.of(1,2,3,4,5),aTuple5);

        Tuple6 aTuple6 = tuple.truncateAt7();
        assertEquals(Tuple.of(1,2,3,4,5,6),aTuple6);

        Tuple7 aTuple7 = tuple.truncateAt8();
        assertEquals(Tuple.of(1,2,3,4,5,6,7),aTuple7);

        Tuple8 aTuple8 = tuple.truncateAt9();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8),aTuple8);

        Tuple9 aTuple9 = tuple.truncateAt10();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9),aTuple9);

        Tuple10 aTuple10 = tuple.truncateAt11();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10),aTuple10);

        Tuple11 aTuple11 = tuple.truncateAt12();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11),aTuple11);

        Tuple12 aTuple12 = tuple.truncateAt13();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12),aTuple12);

        Tuple13 aTuple13 = tuple.truncateAt14();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13),aTuple13);

        Tuple14 aTuple14 = tuple.truncateAt15();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14),aTuple14);

        Tuple15 aTuple15 = tuple.truncateAt16();
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15),aTuple15);
    }

    @Test
    public void testMap_Pass() {
        String mapped = tuple.map((a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p) -> String.format("(%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d)",
                a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p));
        assertEquals("(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16)",mapped);
    }

    @Test
    public void testMatch_Pass() {
        AtomicInteger index = new AtomicInteger();
        index.set(0);
        tuple.match(allOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16), (a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p) -> index.incrementAndGet());
        tuple.match(anyOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,16), (a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p) -> index.incrementAndGet());
        tuple.match(setOf(16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1), (a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p) -> index.incrementAndGet());

        assertEquals(3,index.get());
    }

    @Test
    public void testMapAt_Pass() {
        Tuple16 aTuple16;

        aTuple16 = tuple.mapAt1(a -> 0);
        assertEquals(Tuple.of(0,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16),aTuple16);

        aTuple16 = tuple.mapAt2(a -> 0);
        assertEquals(Tuple.of(1,0,3,4,5,6,7,8,9,10,11,12,13,14,15,16),aTuple16);

        aTuple16 = tuple.mapAt3(a -> 0);
        assertEquals(Tuple.of(1,2,0,4,5,6,7,8,9,10,11,12,13,14,15,16),aTuple16);

        aTuple16 = tuple.mapAt4(a -> 0);
        assertEquals(Tuple.of(1,2,3,0,5,6,7,8,9,10,11,12,13,14,15,16),aTuple16);

        aTuple16 = tuple.mapAt5(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,0,6,7,8,9,10,11,12,13,14,15,16),aTuple16);

        aTuple16 = tuple.mapAt6(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,5,0,7,8,9,10,11,12,13,14,15,16),aTuple16);

        aTuple16 = tuple.mapAt7(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,5,6,0,8,9,10,11,12,13,14,15,16),aTuple16);

        aTuple16 = tuple.mapAt8(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,0,9,10,11,12,13,14,15,16),aTuple16);

        aTuple16 = tuple.mapAt9(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,0,10,11,12,13,14,15,16),aTuple16);

        aTuple16 = tuple.mapAt10(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,0,11,12,13,14,15,16),aTuple16);

        aTuple16 = tuple.mapAt11(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,0,12,13,14,15,16),aTuple16);

        aTuple16 = tuple.mapAt12(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,0,13,14,15,16),aTuple16);

        aTuple16 = tuple.mapAt13(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,0,14,15,16),aTuple16);

        aTuple16 = tuple.mapAt14(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,0,15,16),aTuple16);

        aTuple16 = tuple.mapAt15(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,0,16),aTuple16);

        aTuple16 = tuple.mapAt16(a -> 0);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0),aTuple16);
    }
}
