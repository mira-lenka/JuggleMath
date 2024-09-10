package com.mypibd.juggleMath.Models;

import org.junit.jupiter.api.Test;

import static com.mypibd.juggleMath.Models.Combinatorics.*;
import static org.junit.jupiter.api.Assertions.*;

class CombinatoricsTest {

    @Test
    public void testCombination(){

        assertEquals(combination(4,2),6);
        assertEquals(combination(4,7),0);
        assertEquals(combination(22,1),22);
        assertEquals(combination(43,0),1);
        assertEquals(combination(-22,-1),0);
        assertEquals(combination(5,-1),0);
        assertEquals(combination(-2,-5),0);
    }

    @Test
    public void testVariationWithRepetition() {

        assertEquals(variationWithRepetition(2,4),16);
        assertEquals(variationWithRepetition(-2,-3),0);
        assertEquals(variationWithRepetition(2,-3),0);
        assertEquals(variationWithRepetition(-2,3),0);
        assertEquals(variationWithRepetition(5,0),1);
    }

    @Test
    public void testVariationWithoutRepetition(){

        assertEquals(variationWithoutRepetition(6,10),0);
        assertEquals(variationWithoutRepetition(5,5),120);
        assertEquals(variationWithoutRepetition(10,3),720);
        assertEquals(variationWithoutRepetition(5,-5),0);
    }

    @Test
    public void testPermutation() {

        assertEquals(permutation(5),120);
        assertEquals(permutation(0),1);
        assertEquals(permutation(-5),0);
    }

}