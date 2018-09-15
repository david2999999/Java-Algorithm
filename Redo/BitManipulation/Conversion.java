package Redo.BitManipulation;

public class Conversion {
    private int lessOptimized(int a, int b) {
        int count = 0;

        for (int c = a ^ b; c != 0; c >>= 1) {
            count += (c & 1);
        }

        return count;
    }

    private int optimized(int a, int b) {
        int count = 0;

        for (int c = a ^ b; c != 0; c = c & (c - 1)) {
            count++;
        }

        return count;
    }
}
