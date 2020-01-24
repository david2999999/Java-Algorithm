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

    // We can reduce our space usage by a factor of eight by using a bit vector. We will assume, in the below code,
    //that the string only uses the lowercase letters a through z. This will allow us to use just a single int.
    public boolean isUniqueChars2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); str++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;

            checker |= (1 << val);
        }

        return true;
    }

    // If we can't use additional data structures, we can do the following:
    //1. Compare every character of the string to every other character of the string. This will take 0( n2) time
    //and 0(1) space.

    //2. If we are allowed to modify the input string, we could sort the string in O(n log(n)) time and then
    //linearly check the string for neighboring characters that are identical. Careful, though: many sorting
    //algorithms take up extra space.

}