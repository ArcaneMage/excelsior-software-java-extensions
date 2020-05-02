package com.excelsior.core.tuple;

import com.excelsior.core.Nullable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tuple15Test {
    private Tuple15<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,
            Integer,Integer,Integer> tuple;

    @BeforeEach
    public void setup() {
        tuple = Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
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
    }

    @Test
    public void testAddAt_Pass() {
        Tuple16 tuple16 = tuple.addAt1("a");
        assertEquals(Tuple.of("a",1,2,3,4,5,6,7,8,9,10,11,12,13,14,15),tuple16);

        tuple16 = tuple.addAt2("a");
        assertEquals(Tuple.of(1,"a",2,3,4,5,6,7,8,9,10,11,12,13,14,15),tuple16);

        tuple16 = tuple.addAt3("a");
        assertEquals(Tuple.of(1,2,"a",3,4,5,6,7,8,9,10,11,12,13,14,15),tuple16);

        tuple16 = tuple.addAt4("a");
        assertEquals(Tuple.of(1,2,3,"a",4,5,6,7,8,9,10,11,12,13,14,15),tuple16);

        tuple16 = tuple.addAt5("a");
        assertEquals(Tuple.of(1,2,3,4,"a",5,6,7,8,9,10,11,12,13,14,15),tuple16);

        tuple16 = tuple.addAt6("a");
        assertEquals(Tuple.of(1,2,3,4,5,"a",6,7,8,9,10,11,12,13,14,15),tuple16);

        tuple16 = tuple.addAt7("a");
        assertEquals(Tuple.of(1,2,3,4,5,6,"a",7,8,9,10,11,12,13,14,15),tuple16);

        tuple16 = tuple.addAt8("a");
        assertEquals(Tuple.of(1,2,3,4,5,6,7,"a",8,9,10,11,12,13,14,15),tuple16);

        tuple16 = tuple.addAt9("a");
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,"a",9,10,11,12,13,14,15),tuple16);

        tuple16 = tuple.addAt10("a");
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,"a",10,11,12,13,14,15),tuple16);

        tuple16 = tuple.addAt11("a");
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,"a",11,12,13,14,15),tuple16);

        tuple16 = tuple.addAt12("a");
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,"a",12,13,14,15),tuple16);

        tuple16 = tuple.addAt13("a");
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,"a",13,14,15),tuple16);

        tuple16 = tuple.addAt14("a");
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,"a",14,15),tuple16);

        tuple16 = tuple.addAt15("a");
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,"a",15),tuple16);
    }

    @Test
    public void testJoin_Pass() {
        Tuple15 aTuple15 = tuple.join(Tuple.of());
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15),aTuple15);

        Tuple16 aTuple16_1 = tuple.join("end-of-tuple");
        assertEquals("end-of-tuple",aTuple16_1.value16());
        
        Tuple16 aTuple16_2 = tuple.join(Tuple.of(16));
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16),aTuple16_2);
    }

    @Test
    public void testFromIterable_Pass() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);

        Nullable<Tuple15<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer,
                Integer, Integer, Integer, Integer, Integer>>
                maybeTuple = Tuple15.fromIterable(list);

        maybeTuple.ifPresentOrElse(tuple -> assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15), tuple),
                Assertions::fail);

        list = Arrays.asList(1);
        maybeTuple = Tuple15.fromIterable(list);

        assertTrue(maybeTuple.isEmpty());
    }

    @Test
    public void testSplice_Pass() {
        Tuple2<Tuple0,Tuple15<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer>> spliced1 = tuple.splice(1);
        assertEquals(2, spliced1.depth());
        assertEquals(0, spliced1.value1().depth());
        assertEquals(15, spliced1.value2().value15());

        Tuple2<Tuple1<Integer>,Tuple14<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer>> spliced2 = tuple.splice(2);
        assertEquals(2, spliced2.depth());
        assertEquals(1, spliced2.value1().value1());
        assertEquals(15, spliced2.value2().value14());

        Tuple2<Tuple2<Integer,Integer>,Tuple13<Integer,Integer,Integer,Integer,Integer,Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer>> spliced3 = tuple.splice(3);
        assertEquals(2, spliced3.depth());
        assertEquals(1, spliced3.value1().value1());
        assertEquals(15, spliced3.value2().value13());

        Tuple2<Tuple3<Integer,Integer,Integer>,Tuple12<Integer,Integer,Integer,Integer,Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer>> spliced4 = tuple.splice(4);
        assertEquals(2, spliced4.depth());
        assertEquals(1, spliced4.value1().value1());
        assertEquals(15, spliced4.value2().value12());

        Tuple2<Tuple4<Integer,Integer,Integer,Integer>,Tuple11<Integer,Integer,Integer,Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer>> spliced5 = tuple.splice(5);
        assertEquals(2, spliced5.depth());
        assertEquals(1, spliced5.value1().value1());
        assertEquals(15, spliced5.value2().value11());

        Tuple2<Tuple5<Integer,Integer,Integer,Integer,Integer>,Tuple10<Integer,Integer,Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer>> spliced6 = tuple.splice(6);
        assertEquals(2, spliced6.depth());
        assertEquals(1, spliced6.value1().value1());
        assertEquals(15, spliced6.value2().value10());

        Tuple2<Tuple6<Integer,Integer,Integer,Integer,Integer,Integer>,Tuple9<Integer,Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer>> spliced7 = tuple.splice(7);
        assertEquals(2, spliced7.depth());
        assertEquals(1, spliced7.value1().value1());
        assertEquals(15, spliced7.value2().value9());

        Tuple2<Tuple7<Integer,Integer,Integer,Integer,Integer,Integer,Integer>,Tuple8<Integer,Integer,
                Integer,Integer,Integer,Integer,Integer,Integer>> spliced8 = tuple.splice(8);
        assertEquals(2, spliced8.depth());
        assertEquals(1, spliced8.value1().value1());
        assertEquals(15, spliced8.value2().value8());

        Tuple2<Tuple8<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer>,Tuple7<Integer,
                Integer,Integer,Integer,Integer,Integer,Integer>> spliced9 = tuple.splice(9);
        assertEquals(2, spliced9.depth());
        assertEquals(1, spliced9.value1().value1());
        assertEquals(15, spliced9.value2().value7());

        Tuple2<Tuple9<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer>,
                Tuple6<Integer,Integer,Integer,Integer,Integer,Integer>> spliced10 = tuple.splice(10);
        assertEquals(2, spliced10.depth());
        assertEquals(1, spliced10.value1().value1());
        assertEquals(15, spliced10.value2().value6());

        Tuple2<Tuple10<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer>,
                Tuple5<Integer,Integer,Integer,Integer,Integer>> spliced11 = tuple.splice(11);
        assertEquals(2, spliced11.depth());
        assertEquals(1, spliced11.value1().value1());
        assertEquals(15, spliced11.value2().value5());

        Tuple2<Tuple11<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer>,
                Tuple4<Integer,Integer,Integer,Integer>> spliced12 = tuple.splice(12);
        assertEquals(2, spliced12.depth());
        assertEquals(1, spliced12.value1().value1());
        assertEquals(15, spliced12.value2().value4());

        Tuple2<Tuple12<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer>,
                Tuple3<Integer,Integer,Integer>> spliced13 = tuple.splice(13);
        assertEquals(2, spliced13.depth());
        assertEquals(1, spliced13.value1().value1());
        assertEquals(15, spliced13.value2().value3());

        Tuple2<Tuple13<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer>,
                Tuple2<Integer,Integer>> spliced14 = tuple.splice(14);
        assertEquals(2, spliced14.depth());
        assertEquals(1, spliced14.value1().value1());
        assertEquals(15, spliced14.value2().value2());

        Tuple2<Tuple14<Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer,Integer>,
                Tuple1<Integer>> spliced15 = tuple.splice(15);
        assertEquals(2, spliced15.depth());
        assertEquals(1, spliced15.value1().value1());
        assertEquals(15, spliced15.value2().value1());
    }

    @Test
    public void testRemove_Pass() {
        Tuple14 tuple14 = tuple.remove(15);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14),tuple14);

        Tuple14 tuple14_2 = tuple.remove(10);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,11,12,13,14,15),tuple14_2);

        Tuple14 tuple14_3 = tuple.remove(1);
        assertEquals(Tuple.of(2,3,4,5,6,7,8,9,10,11,12,13,14,15),tuple14_3);
    }

    @Test
    public void testTruncate_Pass() {
        Tuple0 aTuple0 = tuple.truncate(1);
        assertEquals(Tuple.of(),aTuple0);

        Tuple1 aTuple1 = tuple.truncate(2);
        assertEquals(Tuple.of(1),aTuple1);

        Tuple2 aTuple2 = tuple.truncate(3);
        assertEquals(Tuple.of(1,2),aTuple2);

        Tuple3 aTuple3 = tuple.truncate(4);
        assertEquals(Tuple.of(1,2,3),aTuple3);

        Tuple4 aTuple4 = tuple.truncate(5);
        assertEquals(Tuple.of(1,2,3,4),aTuple4);

        Tuple5 aTuple5 = tuple.truncate(6);
        assertEquals(Tuple.of(1,2,3,4,5),aTuple5);

        Tuple6 aTuple6 = tuple.truncate(7);
        assertEquals(Tuple.of(1,2,3,4,5,6),aTuple6);

        Tuple7 aTuple7 = tuple.truncate(8);
        assertEquals(Tuple.of(1,2,3,4,5,6,7),aTuple7);

        Tuple8 aTuple8 = tuple.truncate(9);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8),aTuple8);

        Tuple9 aTuple9 = tuple.truncate(10);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9),aTuple9);

        Tuple10 aTuple10 = tuple.truncate(11);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10),aTuple10);

        Tuple11 aTuple11 = tuple.truncate(12);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11),aTuple11);

        Tuple12 aTuple12 = tuple.truncate(13);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12),aTuple12);

        Tuple13 aTuple13 = tuple.truncate(14);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13),aTuple13);

        Tuple14 aTuple14 = tuple.truncate(15);
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14),aTuple14);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testTestTransform_Pass() {
        Tuple15 aTuple15;

        aTuple15 = tuple.transform1( a -> 0 );
        assertEquals(Tuple.of(0,2,3,4,5,6,7,8,9,10,11,12,13,14,15),aTuple15);

        aTuple15 = tuple.transform2( a -> 0 );
        assertEquals(Tuple.of(1,0,3,4,5,6,7,8,9,10,11,12,13,14,15),aTuple15);

        aTuple15 = tuple.transform3( a -> 0 );
        assertEquals(Tuple.of(1,2,0,4,5,6,7,8,9,10,11,12,13,14,15),aTuple15);

        aTuple15 = tuple.transform4( a -> 0 );
        assertEquals(Tuple.of(1,2,3,0,5,6,7,8,9,10,11,12,13,14,15),aTuple15);

        aTuple15 = tuple.transform5( a -> 0 );
        assertEquals(Tuple.of(1,2,3,4,0,6,7,8,9,10,11,12,13,14,15),aTuple15);

        aTuple15 = tuple.transform6( a -> 0 );
        assertEquals(Tuple.of(1,2,3,4,5,0,7,8,9,10,11,12,13,14,15),aTuple15);

        aTuple15 = tuple.transform7( a -> 0 );
        assertEquals(Tuple.of(1,2,3,4,5,6,0,8,9,10,11,12,13,14,15),aTuple15);

        aTuple15 = tuple.transform8( a -> 0 );
        assertEquals(Tuple.of(1,2,3,4,5,6,7,0,9,10,11,12,13,14,15),aTuple15);

        aTuple15 = tuple.transform9( a -> 0 );
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,0,10,11,12,13,14,15),aTuple15);

        aTuple15 = tuple.transform10( a -> 0 );
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,0,11,12,13,14,15),aTuple15);

        aTuple15 = tuple.transform11( a -> 0 );
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,0,12,13,14,15),aTuple15);

        aTuple15 = tuple.transform12( a -> 0 );
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,0,13,14,15),aTuple15);

        aTuple15 = tuple.transform13( a -> 0 );
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,0,14,15),aTuple15);

        aTuple15 = tuple.transform14( a -> 0 );
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,0,15),aTuple15);

        aTuple15 = tuple.transform15( a -> 0 );
        assertEquals(Tuple.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,0),aTuple15);
    }
}
