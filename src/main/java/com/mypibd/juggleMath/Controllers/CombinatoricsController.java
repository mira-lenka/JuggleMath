package com.mypibd.juggleMath.Controllers;

import com.mypibd.juggleMath.Models.Combinatorics;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/combinatorics")
public class CombinatoricsController {

    @PostMapping(value = "/combination")
    public int combination(@RequestBody CombinationRequest combinationRequest) {
        int n = combinationRequest.getN();
        int k = combinationRequest.getK();

        return Combinatorics.combination(n,k);
    }

    @PostMapping("/variation")
    public int variation(@RequestBody CombinationRequest combinationRequest) {
        int n = combinationRequest.getN();
        int k = combinationRequest.getK();

        return Combinatorics.variationWithoutRepetition(n,k);
    }

    @PostMapping("/variationwr")
    public int variationWR(@RequestBody CombinationRequest combinationRequest) {
        int n = combinationRequest.getN();
        int k = combinationRequest.getK();

        return Combinatorics.variationWithRepetition(n,k);
    }

    @PostMapping("/permutation")
    public int permutation(@RequestBody PermutationRequest permutationRequest) {
        int n = permutationRequest.getN();

        return Combinatorics.permutation(n);
    }
    public static class CombinationRequest {

        private int n;

        private int k;

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public int getK() {
            return k;
        }

        public void setK(int k) {
            this.k = k;
        }
    }

    public static class PermutationRequest {

        private int n;

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }
    }
}

