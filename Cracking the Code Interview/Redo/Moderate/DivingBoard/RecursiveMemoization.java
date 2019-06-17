package Redo.Moderate.DivingBoard;

import java.util.HashSet;

public class RecursiveMemoization {
    private HashSet<Integer> getAllLengths(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();
        HashSet<String> visited = new HashSet<>();

        getAllLengths(k, 0, shorter, longer, lengths, visited);
        return lengths;
    }

    private void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths, HashSet<String> visited) {
        if (k == 0) {
            lengths.add(total);
            return;
        }

        String key = k + " " + total;

        if (visited.contains(key)) return;

        getAllLengths(k - 1, total + shorter, shorter, longer, lengths, visited);
        getAllLengths(k - 1, total + longer, shorter, longer, lengths, visited);
    }
}
