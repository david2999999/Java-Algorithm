public class IsUnique {
    // The time complexity for this code isO( n ), where n is the length of the string. The space complexity isO(l ).
    //(You could also argue the time complexity is 0(1), since the for loop will never iterate through more than
    //128 characters.) If you didn't want to assume the character set is fixed, you could express the complexity as
    //O( c) space and O(min ( c, n)) or O( c) time, where c is the size of the character set.
    public boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);

            if (char_set[i]) {
                return false;
            }
            char_set[i] = true;
        }

        return true;
    }
}