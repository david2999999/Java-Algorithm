package RecursionAndDynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class Parens {
    private Set<String> generateParams(int remaining) {
        Set<String> set = new HashSet<>();
        if (remaining == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParams(remaining - 1);
            for (String str: prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertInside(str, i);
                        set.add(s);
                    }
                }

                set.add("()" + str);
            }
        }

        return set;
    }

    private String insertInside(String str, int i) {
        String start = str.substring(0, i + 1);
        String end = str.substring(i + 1, str.length());
        return start + "()" + end;
    }
}
