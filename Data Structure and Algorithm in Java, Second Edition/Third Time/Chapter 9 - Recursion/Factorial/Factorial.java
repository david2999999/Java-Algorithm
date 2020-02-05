public class Factorial {
    public int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public int factorialIterative(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}