public class FactorialFunction {
    public int[] allFactorials(int n) {
        int[] results = new int[n == 0 ? 1 : n];
        factorial(n, results, 0);
        return results;
    }

    private int factorial(int n, int[] results, int level) {
        if (n > 1) {
            results[level] = n * factorial(n - 1, results, level + 1);
            return results[level];
        } else {
            results[level] = 1;
            return 1;
        }
    }
}
