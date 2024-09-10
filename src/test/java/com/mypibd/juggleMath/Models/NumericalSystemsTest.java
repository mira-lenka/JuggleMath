package com.mypibd.juggleMath.Models;

import org.junit.jupiter.api.Test;

import static com.mypibd.juggleMath.Models.NumericalSystems.*;
import static org.junit.jupiter.api.Assertions.*;

class NumericalSystemsTest {

    @Test
    public void testChangeOfBase(){

            assertEquals(changeOfBase(10,2,"2345"), "100100101001");
            assertEquals(changeOfBase(10,8,"4567"), "10727");
            assertEquals(changeOfBase(10,16,"4567"), "11D7");
            assertEquals(changeOfBase(8,16,"10727"), "11D7");
            assertEquals(changeOfBase(10,7,"63"), "120");
        assertEquals(changeOfBase(10,3,"100"), "10201");

    }

    @Test
    public void testDoubleToBinary() {

        assertEquals(doubleToBinary("65.125"),"1000001.001");
        assertEquals(doubleToBinary("8.25"),"1000.01");
        assertEquals(doubleToBinary("123.625"),"1111011.101");

    }

    @Test
    public void testDoubleToDec() {

        assertEquals(doubleToDec("1000001.001"),"65.125");
        assertEquals(doubleToDec("1000.01"),"8.25");
        assertEquals(doubleToDec("1111011.101"),"123.625");

    }

    @Test
    public void testBinaryArithmetic(){

        assertEquals(binaryAddition("10011101","1111011"),"100011000");
        assertEquals(binarySubtraction("10011101","1111011"),"100010");
        assertEquals(binaryMultiplication("10011101","1111011"),"100101101101111");
        assertEquals(binaryDivision("10011100","11"),"110100");

    }

}