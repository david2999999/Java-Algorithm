package Redo.RecursionAndDynamicProgramming.PermutationOfString;

import java.util.ArrayList;

public class Permutation2 {
    private ArrayList<String> findPerm(String str) {
        if (str == null) return null;

        int len = str.length();
        ArrayList<String> permutations = new ArrayList<>();

        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        for (int i = 0; i < len; i++) {
            String before = str.substring(0, i);
            String after = str.substring(i + 1, len);

            ArrayList<String> words = findPerm(before + after);

            for (String word: words) {
                permutations.add(str.charAt(i) + word);
            }
        }

        return permutations;
    }
}
