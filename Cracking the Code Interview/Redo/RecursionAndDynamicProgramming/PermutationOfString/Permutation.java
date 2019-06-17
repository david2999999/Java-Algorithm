package Redo.RecursionAndDynamicProgramming.PermutationOfString;

import java.util.ArrayList;

public class Permutation {
    private ArrayList<String> findPermutation(String str) {
        if (str == null) return null;

        ArrayList<String> permutations = new ArrayList<>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remainder = str.substring(1);

        ArrayList<String> words = findPermutation(remainder);

        for (String word: words) {
            for (int i = 0; i <= word.length(); i++) {
                String s = insertCharAt(word, first, i);
                permutations.add(s);
            }
        }

        return permutations;
    }


    private String insertCharAt(String word, char letter, int index) {
        String start = word.substring(0, index);
        String end = word.substring(index);
        return start + letter + end;
    }
}
