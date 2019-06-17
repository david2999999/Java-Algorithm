package Redo.BitManipulation;

public class FirstSmallerBinary {
    private int findSmallerValue(int n) {
        int c = n;
        int c0 = 0;
        int c1 = 0;

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        if (c == 0) return -1;

        while ((c & 1) == 0 && c != 0) {
            c0++;
            c >>= n;
        }

        int p = c0 + c1;

        n &= ((~0) << (p + 1));

        int ones = (1 << (c1 + 1)) - 1;
        n |= ones << (c0 -1);

        return n;

    }
}
