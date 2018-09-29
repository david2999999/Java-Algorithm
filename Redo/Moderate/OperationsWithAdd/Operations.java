package Redo.Moderate.OperationsWithAdd;

public class Operations {
    private int negate(int n) {
        int neg = 0;
        int newSign = n < 0 ? 1 : -1;
        int delta = newSign;

        while (n != 0) {
            boolean signDiff = (n + delta > 0) != (n > 0);
            if (signDiff && (n + delta != 0)) {
                delta = newSign;
            }

            neg += delta;
            n += delta;
            delta += delta;
        }

        return neg;
    }

    private int abs(int n) {
        if (n < 0) return negate(n);

        return n;
    }

    private int subtract(int a, int b) {
        return a + negate(b);
    }

    private int multiply(int a, int b) {
        if (a < b) return multiply(b, a);

        int sum = 0;
        for (int i = abs(b); i > 0; i = subtract(i, 1)) {
            sum += a;
        }

        if (b < 0) return negate(sum);

        return sum;
    }
}
