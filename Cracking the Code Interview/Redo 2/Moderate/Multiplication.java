package Moderate;

// implement the Multiplication operator for integers
// use only the add operator
public class Multiplication {
    private int negate(int a) {
        int neg = 0;    // neg = (-1) * a
        int newSign = a < 0 ? 1 : -1;   // opposite sign of a

        while (a != 0) {
            neg += newSign;
            a += newSign;
        }

        return neg;
    }

    // minus operator without addition
    private int minus(int a, int b) {
        return a + negate(b);
    }

    // to multiply a by b
    // we basically add a to itself b times
    public int multiply(int a, int b) {
        if (a < b) {
            return multiply(b, a);  // more faster if b < a
        }

        int sum = 0;
        for (int i = abs(b); i > 0; i = minus(i, 1)) {
            sum += a;
        }

        if (b < 0) {    // if b is negative, then we have to multiply the sum by -1
            sum = negate(sum);  // which is basically negating the sum
        }

        return sum; // basically return the product
    }

    // return the absolute value
    private int abs(int a) {
        if (a < 0) {
            return negate(a);
        } else {
            return a;
        }
    }
}













