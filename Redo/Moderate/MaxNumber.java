package Redo.Moderate;

public class MaxNumber {
    private int getMax(int a, int b) {
        int c = a - b;

        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        int use_sign_of_a = sa ^ sb;
        int use_sign_of_c = flip(sa ^ sb);

        int k = use_sign_of_a * sa + use_sign_of_c * sc;
        int q = flip(k);

        return a * k + b * q;

    }

    private int sign(int a) {
        return flip((a >> 31) & 0x1);
    }

    private int flip(int bit) {
        return 1 ^ bit;
    }
}
