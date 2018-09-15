package Redo.BitManipulation;

public class Insertion {
    private int updateBit(int n, int m, int i, int j) {
        int left_mask = ~0;
        left_mask = (left_mask << (j + 1));

        int right_mask = (1 << i) - 1;

        int mask = left_mask | right_mask;

        int n_cleared = n & mask;
        int m_shifted = m << i;

        n = n_cleared | m_shifted;
        return n;
    }
}
