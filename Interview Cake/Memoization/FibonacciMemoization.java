public class FibonacciMemoization {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Index can not be negative.");
        } else if (n == 0 || n == 1) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);

        return result;
    }
}