package Moderate;

public class NumberMaxWIthoutComparatorOptimized {
    private int getMax(int a, int b) {
        int c = a - b;

        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        int useSignOfA = sa ^ sb;
        int useSignOfC = flip(sa ^ sb);

        int k = useSignOfA * sa + useSignOfC * sc;
        int q = flip(k);

        return k * a + q * b;
    }

    private int flip(int bit) {
        return 1 ^ bit;
    }

    private int sign(int a) {
        return flip((a >> 31) & 0x1);
    }
}
