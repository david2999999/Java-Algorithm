package RecursionAndDynamicProgramming;

public class RecursiveMultiplyWithCache {
    private int minProduct(int a, int b) {
        int smaller = a < b ? a : b;
        int larger = a < b ? b : a;
        int[] memo = new int[smaller + 1];
        return minProductHelp(smaller, larger, memo);
    }

    private int minProductHelp(int smaller, int larger, int[] memo) {
        if (smaller == 0) return 0;
        else if (smaller == 1) return larger;
        else if (memo[smaller] > 0) return memo[smaller];

        int s = smaller >> 1;
        int side1 = minProductHelp(s, larger, memo);
        int side2 = side1;

        if (smaller % 2 == 1) {
            side2 = minProductHelp(smaller - s, larger, memo);
        }

        memo[smaller] = side1 + side2;
        return memo[smaller];
    }
}
