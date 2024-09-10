package com.mypibd.juggleMath.Models;

public abstract class NumberTheory {
        public static int intCodingFunction(int x, int a, int b) {

            int n =26;
            return (a*x+b)%n;

        }

public static class FunctionParameters {

    int a;
    int b;

    public FunctionParameters(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
    public static FunctionParameters reverseFunction(int a,int b) {

        int c = inverseNumber(a,26);
        int d = (-c*b % 26 + 26) % 26;


        return new FunctionParameters(c,d);

    }

    public static char charCodingFunction(char ch, int a, int b) {

        int x = ch;
        x -= 65;
        x = intCodingFunction(x,a,b);
        return (char) (x + 65);

    }

    public static int inverseNumber(int a, int n) {
        int inverse;

        if (gcd(a, n) != 1) {

            inverse = 0;
        } else {

            int x = extendedEuclidean(a, n).getX();
            inverse = (x % n + n) % n;
        }

        return inverse;
    }


    public static String stringCodingFunction(String string, int a,int b) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i< string.length();i++) {
            char ch = string.charAt(i);
            ch = charCodingFunction(ch,a,b);
            result.append(ch);
        }
        return result.toString();
    }

    public static int multiplicationModulo(int a, int b, int m) {


        m = Math.abs(m);

        int A = (a % m + m) % m;
        int B = (b % m + m) % m;


        int sum = 0;

        while (B != 0) {
            if (B%2 == 1) {
                sum += A%m;
            }
            A = 2*A%m;
            B = B/2;
        }

        return sum;
    }

    public static int powerModulo(int a, int k, int m) {

        int A = a;
        int K = k;

        int product = 1;

        while (K!=0) {
            if (K%2==1) {
                product *= A;
            }
            A = (int) Math.pow(A,2) % m;
            K = K/2;

        }

        return product%m;

    }


    public static int gcd(int a, int b) {

        while(a*b != 0) {
            if (a > b) {
                a = a%b;
            }
            else {
                b = b%a;
            }
        }

        return Math.max(a,b);

    }

public static class euclideanThree {

    int gcd;
    int x;
    int y;

    public euclideanThree(int gcd, int x, int y) {
        this.gcd = gcd;
        this.x = x;
        this.y = y;
    }

    public int getGcd() {
        return gcd;
    }

    public void setGcd(int gcd) {
        this.gcd = gcd;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

    public static int euclideanAlgorithm(int a, int b) {

        while (a != b) {

            if (a > b) {
                a = a - b;
            }

            else {
                b = b-a;
            }

        }

        return a;
    }

    public static euclideanThree extendedEuclidean(int a, int b) {

        int c;
        int x_a = 1;
        int y_a = 0;
        int x_b = 0;
        int y_b = 1;

        int x;
        int y;

        while (a*b != 0) {

            if (a >= b) {
                c = a/b;
                a = a %b;
                x_a = x_a - x_b*c;
                y_a = y_a - y_b*c;
            }

            else {
                c = b/a;
                b = b%a;
                x_b = x_b - x_a*c;
                y_b = y_b - y_a*c;
            }
        }

        if (a>0) {
            x = x_a;
            y= y_a;
        }
        else {
            x = x_b;
            y = y_b;
        }

        return new euclideanThree(a+b,x,y);
    }

}

