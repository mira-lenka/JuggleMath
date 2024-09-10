package com.mypibd.juggleMath.Models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {



    @Test
    public void testBinaryOperations(){

        double[][] a = {{1,2,3},{4,2,1}};

        Matrix A = new Matrix(a,2,3);

        Matrix AT = A.transpose();

        double[][] b = {{3,2,1},{0,5,1}};

        Matrix B = new Matrix(b,2,3);

        Matrix BT = B.transpose();

        assertEquals(A.add(B).getMatrix().get(0),new ArrayList<>(Arrays.asList(4.0,4.0,4.0)));
        assertEquals(A.add(B).getMatrix().get(1),new ArrayList<>(Arrays.asList(4.0,7.0,2.0)));

        assertEquals(AT.add(BT).getMatrix().get(0),new ArrayList<>(Arrays.asList(4.0,4.0)));
        assertEquals(AT.add(BT).getMatrix().get(1),new ArrayList<>(Arrays.asList(4.0,7.0)));
        assertEquals(AT.add(BT).getMatrix().get(2),new ArrayList<>(Arrays.asList(4.0,2.0)));

        assertEquals(A.subtract(B).getMatrix().get(0),new ArrayList<>(Arrays.asList(-2.0,0.0,2.0)));
        assertEquals(A.subtract(B).getMatrix().get(1),new ArrayList<>(Arrays.asList(4.0,-3.0,0.0)));

        assertEquals(AT.subtract(BT).getMatrix().get(0),new ArrayList<>(Arrays.asList(-2.0,4.0)));
        assertEquals(AT.subtract(BT).getMatrix().get(1),new ArrayList<>(Arrays.asList(0.0,-3.0)));
        assertEquals(AT.subtract(BT).getMatrix().get(2),new ArrayList<>(Arrays.asList(2.0,0.0)));

        assertEquals(A.multiply(BT).getMatrix().get(0),new ArrayList<>(Arrays.asList(10.0,13.0)));
        assertEquals(A.multiply(BT).getMatrix().get(1),new ArrayList<>(Arrays.asList(17.0,11.0)));

        assertEquals(BT.multiply(A).getMatrix().get(0),new ArrayList<>(Arrays.asList(3.0,6.0,9.0)));
        assertEquals(BT.multiply(A).getMatrix().get(1),new ArrayList<>(Arrays.asList(22.0,14.0,11.0)));
        assertEquals(BT.multiply(A).getMatrix().get(2),new ArrayList<>(Arrays.asList(5.0,4.0,4.0)));

        assertEquals(B.multiply(AT).getMatrix().get(0),new ArrayList<>(Arrays.asList(10.0,17.0)));
        assertEquals(B.multiply(AT).getMatrix().get(1),new ArrayList<>(Arrays.asList(13.0,11.0)));

        assertEquals(AT.multiply(B).getMatrix().get(0),new ArrayList<>(Arrays.asList(3.0,22.0,5.0)));
        assertEquals(AT.multiply(B).getMatrix().get(1),new ArrayList<>(Arrays.asList(6.0,14.0,4.0)));
        assertEquals(AT.multiply(B).getMatrix().get(2),new ArrayList<>(Arrays.asList(9.0,11.0,4.0)));


    }

    @Test
    public void testDetAndInverse() {

        double[][] c = {{1,2},{3,4}};

        Matrix C = new Matrix(c,2,2);


        double[][] d = {{1,0,2},{2,3,2},{0,2,4}};

        Matrix D = new Matrix(d,3,3);

        assertEquals(C.det(),-2.0);
        assertEquals(D.det(),16);

        assertEquals(C.inverse().getMatrix().get(0),new ArrayList<>(Arrays.asList(-2.0,1.0)));
        assertEquals(C.inverse().getMatrix().get(1),new ArrayList<>(Arrays.asList(1.5,-.5)));

        assertEquals(D.inverse().getMatrix().get(0),new ArrayList<>(Arrays.asList(.5,0.25,-0.375)));
        assertEquals(D.inverse().getMatrix().get(1),new ArrayList<>(Arrays.asList(-.5,0.25,0.125)));
        assertEquals(D.inverse().getMatrix().get(2),new ArrayList<>(Arrays.asList(.25,-0.125,0.1875)));

    }

    @Test
    public void testTranspose(){

        double[][] a = {{1,2,3},{4,2,1}};

        Matrix A = new Matrix(a,2,3);

        assertEquals(A.getColumnNumber(),A.transpose().getRowNumber());
        assertEquals(A.getRowNumber(),A.transpose().getColumnNumber());
        assertEquals(A.transpose().getMatrix().get(0),new ArrayList<>(Arrays.asList(1.0,4.0)));
        assertEquals(A.transpose().getMatrix().get(1),new ArrayList<>(Arrays.asList(2.0,2.0)));
        assertEquals(A.transpose().getMatrix().get(2),new ArrayList<>(Arrays.asList(3.0,1.0)));


    }



}