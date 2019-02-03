package Moderate.DivingBoard;

import java.util.HashSet;

public class Solution1 {
    public HashSet<Integer> allLengths(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        getAllLengths(k, 0, shorter, longer, lengths);
        return lengths;
    }

    private void getAllLengths(int k, int total, int shorter, int longer,
                               HashSet<Integer> lengths) {
        if (k == 0) {
            lengths.add(total);
            return;
        }

        getAllLengths(k - 1, total + shorter, shorter, longer, lengths);
        getAllLengths(k - 1, total + longer, shorter, longer, lengths);
    }
}
