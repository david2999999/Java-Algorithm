package Redo.BitManipulation;

public class SwapEvenAndOdd {
    private int swap(int a) {
        return ((a & 0xaaaaaaaa) >>> 1 | (a & 0x55555555) << 1);
    }
}
