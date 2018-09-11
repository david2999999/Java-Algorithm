package Redo;

import java.util.Arrays;

public class CheckPermutation {
    private String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private boolean isPermutations(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        return sort(str1).equals(sort(str2));
    }

    private boolean checkCount(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        int[] count = new int[128];

        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            count[str2.charAt(i)]--;

            if (count[str2.charAt(i)] < 0) return false;
        }

        return true;
    }
}
