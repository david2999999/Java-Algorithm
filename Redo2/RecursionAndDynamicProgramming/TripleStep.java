package RecursionAndDynamicProgramming;

import java.util.Arrays;

// a child is running up a staircase with n steps and can hop either 1 step, 2 step or 3 steps
// count how many possible ways the child can run up the stairs
public class TripleStep {
    // brute force approach
    // we start with the top stair, and find the number of ways of going down 1 step, 2 step or 3 step
    public int countWays(int n) {
        if (n < 0) {    // went pass the lowest step
            return 0;   // not a possible way, return 0
        } else if (n == 0) {    // we have reached the lowest step
            return 1;
        } else {
            // recursively count the number of ways of going down 1 step, 2 step or 3 step
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    // example with memoization, we are recursing down the same number of steps multiple times
    // we can save the number of ways for a specific step in an array, to prevent multiple recursion on that
    // specific step
    public int countWaysOptimized(int n) {
        int[] memo = new int[n + 1];    // storing the number of ways of each different step into an array
        Arrays.fill(memo, -1);  // populate all the indexes of the array with -1
        return countWaysOptimized(n, memo);
    }

    // the strategy of storing previous values inside a data structure
    // to prevent multiple recursions on the same value is called memoization
    public int countWaysOptimized(int n, int[] memo) {
        if (n < 0) {    // went pass the lowest step, not a way
            return 0;   // return 0
        } else if (n == 0) {    // got to the lowest step
            return 1;
        } else if (memo[n] > -1) {  // the number of ways for this specific step has already been calculated
            return memo[n];
        } else {
            // counting the number of ways of the current step on the stair
            memo[n] = countWaysOptimized(n - 1, memo) + countWaysOptimized(n - 2, memo) +
                    countWaysOptimized(n - 3, memo);

            return memo[n]; // return the number of ways for this step
        }
    }
}













