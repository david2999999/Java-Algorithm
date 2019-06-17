package Moderate.DivingBoard;

import java.util.HashSet;

public class Solution3 {
    public HashSet<Integer> allLengths(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        for (int nShorter = 0; nShorter <= k; nShorter++) {
            int nLonger = k - nShorter;
            int length = nShorter * shorter + nLonger * longer;
            lengths.add(length);
        }

        return lengths;
    }
}
