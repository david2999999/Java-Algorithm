package Moderate;

// implement the Multiplication operator for integers
// use only the add operator
public class Division {
    // for division, we have to find the value X
    // where X = a / b
    // but we can also do a = X * b
    // we need to keep adding b to itself until it reaches a, since we are doing integer division
    // we can just truncate the result
    public int divide(int a, int b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException("ERROR"); // can not divide by 0

        int absA = Math.abs(a);
        int absB = Math.abs(b);

        int product = 0;
        int x = 0;

        while (product + absB <= absA) {    // do not want to product to go pass a
            product += absB;    // adding b to itself
            x++;
        }

        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            // since both are positive or both are negative
            // we do not need to negate the result
            return x;
        } else {
            return negate(x);
        }
    }

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
}
