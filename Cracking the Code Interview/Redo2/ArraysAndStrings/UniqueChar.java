package Redo2.ArraysAndStrings;

public class UniqueChar {
    protected boolean isUniqueChar(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;

            char_set[val] = true;
        }

        return true;
    }

    protected boolean isUniqueChar2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.length() - 'a';

            if ((checker & (1 << val)) > 0)
                return false;

            checker |= (1 << val);
        }

        return true;
    }
}
