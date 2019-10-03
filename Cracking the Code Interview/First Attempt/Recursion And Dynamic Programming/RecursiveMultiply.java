package RecursionAndDynamicProgramming;

public class RecursiveMultiply {
    private int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProductHelp(smaller, bigger);
    }

    private int minProductHelp(int smaller, int bigger) {
        if (smaller == 0) return 0;
        else if (smaller == 1) return bigger;

        int s = smaller >> 1; // divide by 2
        int side1 = minProductHelp(s, bigger);
        int side2 = side1;

        if (side1 % 2 == 1) {
            side2 = minProduct(smaller - s, bigger);
        }

        return side1 + side2;
    }
}
