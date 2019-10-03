package Moderate.PairWithSum;

import java.util.ArrayList;

public class Solution1 {
    public ArrayList<Pair> printPairSums(int[] array, int sum) {
        ArrayList<Pair> results = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    results.add(new Pair(array[i], array[j]));
                }
            }
        }

        return results;
    }
}
