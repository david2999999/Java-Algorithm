package Hard.AddWithoutPlus;

public class Solution2 {
    private int add(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }

        return a;
    }
}
