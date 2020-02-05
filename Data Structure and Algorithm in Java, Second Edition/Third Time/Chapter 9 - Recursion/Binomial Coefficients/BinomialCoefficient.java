public class BinomialCoefficient {
    public int coefficient(int n, int k) {
        if (k == 0 || k == n) return 1;
        return coefficient(n - 1, k - 1) + coefficient(n - 1, k);
    }
}