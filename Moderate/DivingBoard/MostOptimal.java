package Moderate.DivingBoard;

import java.util.HashSet;

public class MostOptimal {
    private HashSet<Integer> getLengths(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        for (int nShorter = 0; nShorter <= k; nShorter++) {
            int nLonger = k - nShorter;
            int length = nLonger * longer + nShorter * shorter;
            lengths.add(length);
        }

        return lengths;
    }
}
