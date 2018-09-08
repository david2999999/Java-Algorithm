package Moderate;

public class NumberMaxWithoutComparator {
    private int flip(int bit) {
        return 1 ^ bit;
    }

    private int sign(int a) {
        return flip((a >> 31) & 0x1);
    }

    private int getMaxNaive(int a, int b) {
        int k = sign(a - b);
        int q = flip(k);
        return a * k + b * q;
    }
}
