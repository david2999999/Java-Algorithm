package Moderate;

public class ImplementSubtractWithAdditionOptimized {
    private int negate(int a) {
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
