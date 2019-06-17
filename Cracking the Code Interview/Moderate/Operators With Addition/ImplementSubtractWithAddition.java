package Moderate;

public class ImplementSubtractWithAddition {
    private int negate(int a) {
        int neg = 0;
        int newSign = a < 0 ? 1 : -1;

        while (a != 0) {
            neg += newSign;
            a += newSign;
        }

        return neg;
    }

    private int subtract(int a, int b) {
        return  a + negate(b);
    }
}
