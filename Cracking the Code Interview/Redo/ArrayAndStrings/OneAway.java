package Redo.ArrayAndStrings;

public class OneAway {
    private boolean isOneAway(String str1, String str2) {
        if (str1.length() == str2.length())
            return oneEditReplacement(str1, str2);
        else if (str1.length() + 1 == str2.length()) {
            return oneEditInsert(str1, str2);
        } else if (str1.length() == str2.length() + 1) {
            return oneEditInsert(str2, str1);
        }

        return false;
    }

    private boolean oneEditInsert(String str1, String str2) {
        int a = 0;
        int b = 0;

        while (a < str1.length() && b < str2.length()) {
            if (str1.charAt(a) != str2.charAt(b)) {
                if (a != b) return false;

                b++;
            } else {
                a++;
                b++;
            }
        }

        return true;
    }

    private boolean oneEditReplacement(String str1, String str2) {
        boolean foundDifference = false;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (foundDifference) return false;

                foundDifference = true;
            }
        }

        return true;
    }

    private boolean oneAwayCombined(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        String s1 = str1.length() < str2.length() ? str1 : str2;
        String s2 = str1.length() < str2.length() ? str2 : str1;


        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;

        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.indexOf(index2)) {
                if (foundDifference) return false;
                foundDifference = true;

                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }

            index2++;
        }

        return true;
    }
}
