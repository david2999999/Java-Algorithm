public class MinProductOptimized {
    public int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProductHelper(smaller, bigger);
    }

    private int minProductHelper(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }

        int s = smaller >> 1;
        int halfProduct = minProduct(s, bigger);

        if (smaller % 2 == 0) {
            return halfProduct + halfProduct;
        } else {
            return halfProduct + halfProduct + bigger;
        }
    }
}