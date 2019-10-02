package Moderate.PairWithSums;

import java.util.ArrayList;

public class BruteForce {
    private ArrayList<Pair> printPairSums(int[] array, int sum) {
        ArrayList<Pair> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j + 1] == sum) {
                    result.add(new Pair(array[i], array[i + 1]));
                }
            }
        }

        return result;
    }
}
