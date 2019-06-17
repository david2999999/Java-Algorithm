package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(getPerms("abc"));
    }

    private static ArrayList<String> getPerms(String str) {
        if (str == null) return null;

        ArrayList<String> permutations = new ArrayList<>();

        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char firstChar = str.charAt(0);
        ArrayList<String> words = getPerms(str.substring(1));

        for (String word: words) {
            for (int i = 0; i <= word.length(); i++) {
                String s = insertCharAt(word, firstChar, i);
                permutations.add(s);
            }
        }

        return permutations;
    }

    private static String insertCharAt(String word, char firstChar, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + firstChar + end;
    }
}
