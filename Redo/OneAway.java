package Redo;

public class OneAway {
    private boolean isOneAway(String str1, String str2) {

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
}
