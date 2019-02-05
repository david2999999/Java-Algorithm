package Moderate.Operations;

public class Subtraction {
    public int minus(int a, int b) {
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

    private int negate2(int a) {
        int neg = 0;
        int newSign = a < 0 ? 1 : -1;
        int delta = newSign;

        while (a != 0) {
            boolean differentSigns = (a + delta > 0) != (a > 0);
            if (a + delta != 0 && differentSigns) {
                delta = newSign;
            }

            neg += delta;
            a += delta;
            delta += delta;
        }

        return neg;
    }
}
