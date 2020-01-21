public class FibonacciMemoization {
    public int fibonacci(int n) {
        return fibonacci(n, new int[n + 1]);
    }

    private int fibonacci(int i, int[] memo) {
        if (i == 0 || i == 1) return i;

        if (memo[i] == 0) {
            memo[i] = fibonacci(i - 1, memo) + fibonacci(i - 2, memo);
        }

        return memo[i];
    }
}