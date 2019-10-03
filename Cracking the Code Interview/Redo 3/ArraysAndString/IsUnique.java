package ArraysAndString;

public class IsUnique {
    public boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];

        for (int i = 0; i < char_set.length; i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }

            char_set[val] = true;
        }

        return true;
    }

    public boolean isUniqueChars2(String str) {
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            // assuming lowercase a - z
            int val = str.charAt(i) - 'a';

            // checking if the bit at that position is already a 1
            if ((checker & (1 << val)) > 0) {
                return false;
            }

            // set the bit at that position to 1
            checker |= (1 << val);
        }

        return true;
    }
}
