public class MinProductBruteForce {
    public int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;

        return minProductHelper(smaller, bigger);
    }

    private int minProductHelper(int smaller, int larger) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return larger;
        }

        int s = smaller >> 1;
        int side1 = minProductHelper(s, larger);
        int side2 = side1;

        if (smaller % 2 == 1) {
            side2 = minProductHelper(smaller - s, larger);
        }

        return side1 + side2;
    }
}