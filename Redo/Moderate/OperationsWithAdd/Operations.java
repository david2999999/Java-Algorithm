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
}
