public class UniqueCharacter {
    public static final String MAX_UNICODE_LETTERS = 128;

    public boolean isUniqueChar(String str) {
        if (str.length() > MAX_UNICODE_LETTERS) return false;

        boolean[] characterFound = new boolean[MAX_UNICODE_LETTERS];    // all value initialized to false

        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);

            if (characterFound[value]) return false;

            characterFound[value] = true;
        }

        return true;
    }
}

// The time complexity for this code isO( n ), where n is the length of the string. The space complexity isO(l ).
//(You could also argue the time complexity is 0(1), since the for loop will never iterate through more than
//128 characters.) If you didn't want to assume the character set is fixed, you could express the complexity as
//O( c) space and O(min ( c, n)) or O( c) time, where c is the size of the character set.