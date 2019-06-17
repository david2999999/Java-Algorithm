package ArraysAndStrings;

public class OneEditAway {
    public boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) { // the first string is longer than second string
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(first, second);
        }

        return false; // is not one edit away nor one edit insert
    }

    private boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;

        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2)
                    return false;

                index2++;   // string2 is the shorter one, we increment the shorter index
            } else {
                index1++;
                index2++;
            }
        }

        return true;
    }

    private boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference)    // difference is already found.
                    return false;

                foundDifference = true; // found the difference between the two strings
            }
        }
        return true;
    }


}
