package ArraysAndStrings;

// convert aabcccccaaa -> a2b1c5a3
public class StringCompression {

    public String compress(String str) {
        StringBuilder compressed = new StringBuilder(); // string builder is much more efficient than concatenating strings

        int countConsecutive = 0;   // counting consecutive letters
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // if we hit the end of the string OR
            // if the current character does not equal the next character
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);    // number of consecutive letters
                countConsecutive = 0;   // reset the counter
            }
        }

        // checking the length of the compressed string
        // if the length of the compressed string is less than the original string, return the compressed string
        // else return the original string
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}
