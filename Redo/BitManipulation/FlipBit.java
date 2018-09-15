package Redo.BitManipulation;

public class FlipBit {
    private int flipBit(int n) {
        if (~n == 0) return Integer.BYTES * 8;

        int previousValue = 0;
        int currentValue = 0;
        int maxbits = 1;

        while (n != 0) {
            if ((n & 1) == 1) {
                currentValue++;
            } else if ((n & 1) == 0) {
                previousValue = (n & 2) == 0 ? 0 : currentValue;
                currentValue = 0;
            }

            maxbits = Math.max(currentValue + previousValue + 1, maxbits);
            n >>>= 1;
        }

        return maxbits;
    }
}
