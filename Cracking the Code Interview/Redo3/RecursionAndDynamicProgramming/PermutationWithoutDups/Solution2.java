package RecursionAndDynamicProgramming.PermutationWithoutDups;

import java.util.ArrayList;

public class Solution2 {
    public ArrayList<String> getPerms(String remainder) {
        int len = remainder.length();
        ArrayList<String> result = new ArrayList<>();

        if (len == 0) {
            result.add("");
            return result;
        }

        for (int i = 0; i < len; i++) {
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, len);
            ArrayList<String> partials = getPerms(before + after);

            for (String s: partials) {
                result.add(remainder.charAt(i) + s);
            }
        }

        return result;
    }
}
