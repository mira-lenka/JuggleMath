package com.mypibd.juggleMath.Models;


public abstract class Combinatorics {

    public static int combination(int n, int k) {

        if (k>n || k < 0) {
            return 0;
        }

        else if (k==0) {
            return 1;
        }

        else if (k > n/2) {
            return combination(n,n-k);
        }

        else {
            return n/k* combination(n-1,k-1);
        }
    }

    //returns number of k-element variations of n objects
    public static int variationWithRepetition(int n, int k) {

        if (n > 0 && k >= 0) {
            return (int) Math.pow(n, k);
        }
        else return 0;
    }

    public static int variationWithoutRepetition(int n, int k) {

        if (k > n) {
            return 0;
        }

        if (k==n) {
            return permutation(n);
        }
        else {
            return factorial(n) / factorial(n-k);
        }
    }

    public static int permutation(int n) {

        return factorial(n);
    }


    public static int factorial(int n) {

        if (n==0 || n==1) {
            return 1;
        }

        else if (n < 0) {
            return 0;
        }

        else {
            return n* factorial(n-1);
        }
    }

}
