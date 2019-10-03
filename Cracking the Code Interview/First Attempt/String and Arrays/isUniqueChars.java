package StringAndArrays;

public class isUniqueChars {
    public static void main(String[] args) {
        System.out.println(isUnique("helo"));
    }

    static boolean isUnique(String str) {
        // if the length is greater than the number of characters in ASCII, there must be a duplicate
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }

            char_set[val] = true;
        }

        return true;
    }
}


