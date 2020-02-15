public class Insertion {
    public int updateBit(int n, int m, int i, int j) {
        int allOnes = ~0;
        int left = allOnes << (j + 1);
        int right = (i << 1) - 1;
        int clear = left | right;

        int nCleared = n & clear;
        int mShifted = m << i;

        return nCleared | mShifted;
    }
}