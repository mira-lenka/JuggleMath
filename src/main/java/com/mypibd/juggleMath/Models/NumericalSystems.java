package com.mypibd.juggleMath.Models;

public abstract class NumericalSystems {


    public static String changeOfBase(int base1, int base2, String number){

        if (base2 == 16) {
            return Integer.toHexString(Integer.parseInt(number, base1)).toUpperCase();
        }

        else {
            return Integer.toString(Integer.parseInt(number, base1), base2).toUpperCase();
        }

    }

    public static String doubleToBinary(String number) {

        double n = Double.parseDouble(number);

        if (n < 1 && n > -1) {
            return fractionToBinary(number);

        }

        String fractionPart = ((Double) (n%1)).toString();

        Integer intPart = (int) Math.floor(n);

        String integerPart = intPart.toString();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(changeOfBase(10,2,integerPart));

        stringBuilder.append(fractionToBinary(fractionPart));

        return stringBuilder.toString();

    }

    public static String fractionToBinary(String number) {

        double n = Double.parseDouble(number);

        double k;

        StringBuilder stringBuilder = new StringBuilder(".");

        while (n!=0 && stringBuilder.length() != 15) {

            k = Math.floor(n*2);

            stringBuilder.append((int) k);

            n = n*2 - k;

        }

        return stringBuilder.toString();
    }

    public static String doubleToDec(String number) {

        double n = Double.parseDouble(number);

        if (n < 1 && n > -1) {
            return fractionToDec(number);
        }

        else {
            char[] array = number.toCharArray();

            StringBuilder intPart = new StringBuilder();
            StringBuilder fracPart = new StringBuilder("0.");

            StringBuilder part = intPart;

            for (char c : array) {
                if (c == '.' || c == ',') {
                    part = fracPart;
                }
                else {
                    part.append(c);
                }
            }


            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(changeOfBase(2,10,intPart.toString()));

            stringBuilder.append(fractionToDec(fracPart.toString()).substring(1));

            return stringBuilder.toString();

        }
    }
    public static String fractionToDec(String number) {

        char[] array = number.toCharArray();

        int i = 1;

        double n = 0;

        for (char c : array) {
            if (c == '1') {
                n += Math.pow(2,i);
            }
            i--;
        }
        return Double.toString(n);
    }

    public static String binaryAddition(String a,String b) {

        return Integer.toString(Integer.parseInt(a,2) + Integer.parseInt(b,2),2);

    }

    public static String binarySubtraction(String a,String b) {

        return Integer.toString(Integer.parseInt(a,2) - Integer.parseInt(b,2),2);

    }

    public static String binaryMultiplication(String a,String b) {

        return Integer.toString(Integer.parseInt(a,2) * Integer.parseInt(b,2),2);

    }

    public static String binaryDivision(String a,String b) {

        return Integer.toString(Integer.parseInt(a,2) / Integer.parseInt(b,2),2);

    }


}
