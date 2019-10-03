package ArraysAndStrings;

public class OneEditAwayOptimized {
    public boolean oneEditAway(String first, String second) {
        // if the 2 strings have a difference in length of more than 1
        if (Math.abs(first.length()) - Math.abs(second.length()) > 1) {
            return false;
        }

        String s1 = first.length() < second.length() ? first : second;  // shorter string
        String s2 = first.length() < second.length() ? second : first;  // longer string

        boolean foundDifference = false;

        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference)
                    return false;

                foundDifference = true;

                if (s1.length() == s2.length()) {   // on replace, more shorter pointer
                    index1++;
                }
            } else {
                index1++;   // if both matches, move the shorter pointer
            }

            index2++;   // the longer pointer always moves
        }

        return true;   
    }
}
