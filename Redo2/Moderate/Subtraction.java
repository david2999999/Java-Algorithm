package Moderate;

// implement the subtract operation for integers
// use only the add operator
public class Subtraction {
    // to implement to subtraction operator
    // we need a negate method,
    // since the general idea of subtraction is a + (-1) * b.
    // but we can not use the multiplication operator, so we will create our own negate method

    // if a is positive, convert to negative
    // if a is negative, convert to positive
    private int negate(int a) {
        int neg = 0;    // neg = (-1) * a
        int newSign = a < 0 ? 1 : -1;   // opposite sign of a

        while (a != 0) {
            neg += newSign;
            a += newSign;
        }

        return neg;
    }

    public int minus(int a, int b) {
        return a + negate(b);
    }

    // we can make the negate method more optimized, by trying to reduce a to zero quicker
    // by reducing by 1, 2, 4, 8, etc.
    private int negateOptimized(int a) {
        int neg = 0;
        int newSign = a < 0 ? 1 : -1;
        int delta = newSign;    // this value will double

        while (a != 0) {
            // checking if 'a' went pass zero because delta is too large
            boolean differentSigns = (a + delta > 0) != (a > 0);
            if (a + delta != 0 && differentSigns) { // if delta is too big, reset it
                delta = newSign;
            }

            neg += delta;
            a += delta;
            delta += delta; // double the delta
        }

        return neg;
    }

    // The runtime of the first negate method is O(a)
    // while the runtime of the optimized method is O(log a),
    // since a is going to zero at a double rate every time
}
















