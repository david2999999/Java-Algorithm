package RecursionAndDynamicProgramming;

public class RecursivelyMultiplyMostEfficient {
    private int minProduct(int a, int b) {
        int smaller = a < b ? a : b;
        int larger = a < b ? b : a;
        return minProductHelper(smaller, larger);
    }

    private int minProductHelper(int smaller, int larger) {
        if (smaller == 0) return 0;
        else if (smaller == 1) return larger;

        int s = smaller >> 1;
        int halfProd = minProductHelper(s, larger);

        if (halfProd % 2 == 0) {
            return halfProd + halfProd;
        } else {
            return halfProd + halfProd + larger;
        }
    }
}
