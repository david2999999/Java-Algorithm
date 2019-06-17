package Redo.RecursionAndDynamicProgramming.Parens;

import java.util.HashSet;
import java.util.Set;

public class Parens {
    private Set<String> generateParam(int remaining) {
        Set<String> set = new HashSet<>();

        if (remaining == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParam(remaining - 1);
            for (String str: prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertParen(str, i);
                        set.add(s);
                    }
                }

                set.add("()" + str);

            }
        }

        return set;
    }

    private String insertParen(String word, int index) {
        String before = word.substring(0, index + 1);
        String after = word.substring(index, word.length());
        return before + "()" + after;
    }
}
