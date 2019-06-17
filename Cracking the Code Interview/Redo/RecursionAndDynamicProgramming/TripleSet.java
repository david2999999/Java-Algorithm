package Redo.RecursionAndDynamicProgramming;

import java.util.Arrays;

public class TripleSet {
    private int countSteps(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countSteps(n, memo);
    }

    private int countSteps(int n, int[] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countSteps(n - 1, memo) + countSteps(n - 2, memo) + countSteps(n - 3);
            return memo[n];
        }
    }
}
