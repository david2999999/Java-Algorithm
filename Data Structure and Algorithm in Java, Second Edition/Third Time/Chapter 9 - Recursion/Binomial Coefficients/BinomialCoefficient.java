public class BinomialCoefficient {
    public int coefficient(int n, int k) {
        if (k == 0 || k == n) return 1;
        return coefficient(n - 1, k - 1) + coefficient(n - 1, k);
    }

    public int coeffcientIterative(int n, int k) {
        if (n < 2 || k == 0 || k == n) return 1;

        int c = 1;
        for (int j = 1; j <= k; j++) {
            c = c * (n - j + 1) / j;
        }

        return c;
    }
}