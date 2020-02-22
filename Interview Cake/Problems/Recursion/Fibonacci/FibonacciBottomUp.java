public class FibonacciBottomUp {
    public int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid index - index can not be negative");
        } else if (n == 0 || n == 1) {
            return n;
        }

        int prevPrev = 0;
        int prev = 1;
        int current = 0;

        for (int i = 1; i < n; i++) {
            current = prevPrev + prev;
            prevPrev = prev;
            prev = current;
        }

        return current;
    }
}