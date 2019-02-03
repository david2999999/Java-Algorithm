package Moderate.DivingBoard;

import java.util.HashSet;

public class Solution2 {
    public HashSet<Integer> allLengths(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        HashSet<String> visited = new HashSet<>();

        getAllLengths(k, 0, shorter, longer, lengths, visited);
        return lengths;
    }

    private void getAllLengths(int k, int total, int shorter, int longer,
                               HashSet<Integer> lengths, HashSet<String> visited) {
        if (k == 0) {
            lengths.add(total);
            return;
        }

        String key = k + " " + total;

        if (visited.contains(key)) {
            return;
        }

        getAllLengths(k, total + shorter, shorter, longer, lengths, visited);
        getAllLengths(k, total + longer, shorter, longer, lengths, visited);
        visited.add(key);
    }
}
