package RecursionAndDynamicProgramming;

// write a recursive function to multiply two positive integers without the * operator or / operator
public class MinProduct {
    // we are going to count half each the numbers and then double it

    public int minProduct(int a, int b) {
        // finding the bigger or smaller number
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;

        return minProductHelper(smaller, bigger);
    }

    private int minProductHelper(int smaller, int bigger) {
        if (smaller == 0) { // 0 x bigger = 0
            return 0;
        } else if (smaller == 1) { // 1 x bigger = bigger
            return bigger;
        }

        int s = smaller >> 1;   // divide the smaller number by 2
        int side1 = minProductHelper(s, bigger);
        int side2 = side1;

        if (smaller % 2 == 1) { // if the smaller side is an odd number
            side2 = minProductHelper(smaller - s, bigger);
        }

        // if the side are even, multiply by 2
        return side1 + side2;
    }

    // a better solution is to cache the results of recursive calls
    public int minProduct2(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;

        int memo[] = new int[smaller + 1];  // cache for previous calls
        return minProductHelper2(smaller, bigger, memo);
    }

    private int minProductHelper2(int smaller, int bigger, int[] memo) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        } else if (memo[smaller] > 0) { // already have a cached result
            return memo[smaller];
        }

        int s = smaller >> 1;   // divide by 2
        int side1 = minProductHelper2(s, bigger, memo); // compute half
        int side2 = side1;

        if (smaller % 2 == 1) { // if the smaller value is odd
            side2 = minProductHelper2(smaller - s, bigger, memo);
        }

        memo[smaller] = side1 + side2;  // sum and cache
        return memo[smaller];
    }
}

























