package ArraysAndString;

import java.util.Arrays;

public class IsPermutation {
    public String sortString(String s) {
        char[] contents = s.toCharArray();
        Arrays.sort(contents);
        return new String(contents);
    }

    public boolean permutation(String s, String t) {
        if (s.length() != t.length()) return false;

        return sortString(s).equals(sortString(t));
    }


    public boolean permutationsWithCount(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] letters = new int[128];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;

            if (letters[t.charAt(i)] < 0) return false;
        }

        return true;
    }
}
