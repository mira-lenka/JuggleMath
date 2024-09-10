package com.mypibd.juggleMath.Controllers;

import com.mypibd.juggleMath.Models.NumberTheory;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/numbertheory")
public class NumberTheoryController {


    @PostMapping("/powermodulo")
    public int powerModulo(@RequestBody ThreeInts threeInts) {
        int a = threeInts.getA();
        int b = threeInts.getB();
        int m = threeInts.getM();

        return NumberTheory.powerModulo(a,b,m);
    }

    @PostMapping("/multimodulo")
    public int multiplicationModulo(@RequestBody ThreeInts threeInts) {

        int a = threeInts.getA();
        int b = threeInts.getB();
        int m = threeInts.getM();

        return NumberTheory.multiplicationModulo(a,b,m);
    }

    @PostMapping("/gcd")
    public int gcd(@RequestBody TwoInts twoInts) {

        int a = twoInts.getA();
        int b = twoInts.getB();

        return NumberTheory.euclideanAlgorithm(a,b);

    }

    @PostMapping("/exteucli")
    public Map<String,Object> extEuclidean(@RequestBody TwoInts twoInts) {

        int a = twoInts.getA();
        int b = twoInts.getB();

        NumberTheory.euclideanThree three = NumberTheory.extendedEuclidean(a,b);

        Map<String,Object> result;
        result = new HashMap<>();

        result.put("x",three.getX());
        result.put("y",three.getY());
        result.put("gcd",three.getGcd());

        return result;
    }

    @PostMapping("/inverse")
    public int Inverse(@RequestBody TwoInts twoInts) {

        int a = twoInts.getA();
        int b = twoInts.getB();

        return NumberTheory.inverseNumber(a,b);
    }

    @PostMapping("/ceasarcode")
    public String CeasarCode(@RequestBody RequestCode requestCode) {

        int a = requestCode.getA();
        int b = requestCode.getB();
        String string = requestCode.getString().toUpperCase();

        return NumberTheory.stringCodingFunction(string,a,b);

    }

    @PostMapping("/decode")
    public NumberTheory.FunctionParameters decode(@RequestBody RequestFunction requestFunction) {

        int a = requestFunction.getA();
        int b = requestFunction.getB();

        return NumberTheory.reverseFunction(a,b);

    }

    public static class RequestFunction {

        int a;
        int b;

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

    public static class RequestCode {

        int a;
        int b;
        String string;

        public RequestCode(int a, int b, String string) {
            this.a = a;
            this.b = b;
            this.string = string;
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

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }
    public static class TwoInts {

        int a;
        int b;

        public TwoInts(int a, int b) {
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

    public static class ThreeInts {

        private int a;
        private int b;
        private int m;

        public ThreeInts(int a, int b, int m) {
            this.a = a;
            this.b = b;
            this.m = m;
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

        public int getM() {
            return m;
        }

        public void setM(int m) {
            this.m = m;
        }
    }

}
