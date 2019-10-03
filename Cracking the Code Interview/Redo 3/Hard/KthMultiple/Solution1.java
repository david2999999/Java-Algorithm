package Hard.KthMultiple;

import java.util.ArrayList;
import java.util.Collections;

public class Solution1 {
    private int getKthMagicNumber(int k) {
        ArrayList<Integer> possibilities = allPossibleFactors(k);
        Collections.sort(possibilities);
        return possibilities.get(k);
    }

    private ArrayList<Integer> allPossibleFactors(int k) {
        ArrayList<Integer> values = new ArrayList<>();
        for (int a = 0; a < k; a++) {
            int powA = (int) Math.pow(3, a);
            for (int b = 0; b < k; b++) {
                int powB = (int) Math.pow(5, b);
                for (int c = 0; c < k; c++) {
                    int powC = (int) Math.pow(7, c);
                    int value = powA * powB * powC;

                    if (value < 0 || powA == Integer.MAX_VALUE || powB == Integer.MAX_VALUE || powC == Integer.MAX_VALUE) {
                        value = Integer.MAX_VALUE;
                    }

                    values.add(value);
                }
            }
        }

        return values;
    }
}
