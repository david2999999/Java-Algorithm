package BitManipulation;

public class Insertion {
    private int updateBit(int n, int m, int i, int j) {
        int allOnes = ~0;
        int left = allOnes << (j + 1);

        int right = ((1 << i) - 1);

        int mask = left | right;
        int n_cleared = n & mask;
        int m_shifted = m << i;

        return n_cleared | m_shifted;

    }
}
