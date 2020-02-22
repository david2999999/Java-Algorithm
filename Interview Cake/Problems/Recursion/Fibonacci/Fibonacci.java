public class Fibonacci {
    public int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Index can not be negative.");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}