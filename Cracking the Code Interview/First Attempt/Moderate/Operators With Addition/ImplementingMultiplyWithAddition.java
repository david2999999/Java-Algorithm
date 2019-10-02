package Moderate;

public class ImplementingMultiplyWithAddition {

    private int multiply(int a, int b) {
        if (a < b) return multiply(b, a);

        int sum = 0;

        for (int i = abs(b); i > 0; i = minus(i, 1)) {
            sum += a;
        }

        if (b < 0) {
            sum = negate(sum);
        }

        return sum;
    }

    private int abs(int a) {
        if (a < 0) {
            return negate(a);
        } else {
            return a;
        }
    }

    private int negate(int a) {
        int neg = 0;
        int newSign = a < 0 ? 1 : -1;

        while (a != 0) {
            neg += newSign;
            a += newSign;
        }

        return neg;
    }

    private int minus(int a, int b) {
        return  a + negate(b);
    }
}
