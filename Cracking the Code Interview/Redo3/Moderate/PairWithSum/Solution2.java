package Moderate.PairWithSum;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution2 {
    public ArrayList<Pair> printPairSums(int[] array, int sum) {
        ArrayList<Pair> result = new ArrayList<>();
        HashMap<Integer, Integer> unpairedCount = new HashMap<>();

        for (int x: array) {
            int complement = sum - x;
            if (unpairedCount.getOrDefault(complement, 0) > 0) {
                result.add(new Pair(x, complement));
                adjustCounterBy(unpairedCount, complement, -1);
            } else {
                adjustCounterBy(unpairedCount, x, 1);
            }
        }

        return result;
    }

    public void adjustCounterBy(HashMap<Integer, Integer> counter, int key, int delta) {
        counter.put(key, counter.getOrDefault(key, 0) + delta);
    }
}
