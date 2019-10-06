package Moderate.PairWithSums;

import java.util.ArrayList;
import java.util.HashMap;

public class OptimizedWithHashmap {
    private ArrayList<Pair> printPairSum(int[] array, int sum) {
        ArrayList<Pair> result = new ArrayList<>();
        HashMap<Integer, Integer> unpairedCount = new HashMap<>();

        for (int x: array) {
            int complement = sum - x;

            if (unpairedCount.getOrDefault(complement, 0) > 0) {
                result.add(new Pair(x, complement));
                adjustCounterBy(unpairedCount, complement, -1);
            } else {
                adjustCounterBy(unpairedCount,x, 1);
            }
        }

        return result;
    }

    private void adjustCounterBy(HashMap<Integer, Integer> counter, int key, int delta) {
        counter.put(key, counter.getOrDefault(key, 0) + delta);
    }
}