package Moderate.Operations;

public class Divide {
    public int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("ERROR");
        }

        int absa = abs(a);
        int absb = abs(b);

        int product = 0;
        int x = 0;

        while (product + absb <= absa) {
            product += absb;
            x++;
        }

        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            return x;
        } else {
            return negate(x);
        }
    }

    private int abs(int a) {
        if (a < 0) {
            return negate(a);
        } else {
            return a;
        }
    }

    private int minus(int a, int b) {
        return a + negate(b);
    }

    private int negate(int a) {
        int neg = 0;
        int newSign = a < 0 ? 1 : -1;

        while (a != 0) {
            a += newSign;
            neg += newSign;
        }

        return neg;
    }

}
