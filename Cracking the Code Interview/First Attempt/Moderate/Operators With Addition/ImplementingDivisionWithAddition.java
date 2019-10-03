package Moderate;

public class ImplementingDivisionWithAddition {
    private int negative(int a, int b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException();

        int absa = abs(a);
        int absb = abs(b);

        int x = 0;
        int product = 0;

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


    private int negate(int a) {
        int neg = 0;
        int newSign = a < 0 ? 1 : -1;

        while (a != 0) {
            neg += newSign;
            a += newSign;
        }

        return neg;
    }

    private int abs(int a) {
        if (a < 0) {
            return negate(a);
        } else {
            return a;
        }
    }
}
