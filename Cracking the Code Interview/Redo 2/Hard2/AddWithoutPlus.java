package Hard2;

// write a function that adds two numbers, you should not use + or any arithmetic operators.
public class AddWithoutPlus {
    // we have to do the addition in binary, here are the steps
    // 1) add two binary numbers together, but forget the carry, the i th bit in the sum will be 0
    // only if a and b have the same ith bit (both 0 or both 1). This is XOR
    // 2) add two binary numbers together but only carry, I will have a 1 in the i th bit of the sum, only
    // if i - 1 of a and b are both 1s. This is an AND operation, shifted to the left
    // 3) recurse until there is no more carry, as it continues to be shifted left
    public int add(int a, int b) {
        if (b == 0) {   // base case, no more carry
            return a;
        }

        int sum = a ^ b;    // the sum of the two numbers without carry
        int carry = (a & b) << 1;   // the carry, but don't add
        return add(sum, carry); // recurse until carry turns to 0
    }

    // there is an iterative solution
    public int add2(int a, int b) {
        // note: b is originally a number to be added with a
        while (b != 0) {    // while the carry is not 0
            int sum = a ^ b;    // the sum of two numbers without carry
            int carry = (a & b) << 1;   // the carry, but don't add
            a = sum;
            b = carry;
        }

        return a;   // the sum of the two numbers
    }
}













