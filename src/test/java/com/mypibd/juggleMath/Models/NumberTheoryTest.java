package com.mypibd.juggleMath.Models;

import org.junit.jupiter.api.Test;

import static com.mypibd.juggleMath.Models.NumberTheory.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberTheoryTest {

    @Test
    public void testMultiplicationModulo() {

        assertEquals(multiplicationModulo(3,9,22),5);
        assertEquals(multiplicationModulo(1,-7,5),3);
        assertEquals(multiplicationModulo(7,9,1),0);
        assertEquals(multiplicationModulo(1,7,-5),2);

    }

    @Test
    public void testPowerModulo() {

        assertEquals(powerModulo(2,4,5),1);
        assertEquals(powerModulo(3,3,12),3);

    }

    @Test
    public void testGcd() {

        assertEquals(gcd(85,3995),85);
        assertEquals(gcd(2961,376),47);
        assertEquals(gcd(83,400),1);

    }

    @Test
    public void testExtendedEuclidean() {

        assertEquals(extendedEuclidean(83,400).gcd,new euclideanThree(1,-53,11).gcd);
        assertEquals(extendedEuclidean(83,400).x,new euclideanThree(1,-53,11).x);
        assertEquals(extendedEuclidean(83,400).y,new euclideanThree(1,-53,11).y);

        assertEquals(extendedEuclidean(45,1150).gcd,new euclideanThree(5,-51,2).gcd);
        assertEquals(extendedEuclidean(45,1150).x,new euclideanThree(5,-51,2).x);
        assertEquals(extendedEuclidean(45,1150).y,new euclideanThree(5,-51,2).y);

    }

    @Test
    public void testInverseNumber() {

        assertEquals(inverseNumber(15,23),20);
        assertEquals(inverseNumber(7,25),18);
        assertEquals(inverseNumber(15,25),0);
        assertEquals(inverseNumber(15,23),20);

    }

    @Test
    public void testStringCodingFunction() {

        assertEquals(stringCodingFunction("MARTA",17,17),"NRUCR");
        assertEquals(stringCodingFunction("NRUCR",23,25),"MARTA");
    }

    @Test
    public void testReverseFunction() {

        assertEquals(reverseFunction(17,17).a, new FunctionParameters(23,25).a);
        assertEquals(reverseFunction(17,17).b, new FunctionParameters(23,25).b);

        assertEquals(reverseFunction(23,25).a, new FunctionParameters(17,17).a);
        assertEquals(reverseFunction(23,25).b, new FunctionParameters(17,17).b);

    }

}