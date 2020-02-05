public class EuclideanAlgorithm {
    public int gcd(int n, int m) {
        if (n == m) {
            return n;
        } else if (n > m) {
            gcd(n - m, m);
        } else {
            gcd(n, m - n);
        }
    }
}