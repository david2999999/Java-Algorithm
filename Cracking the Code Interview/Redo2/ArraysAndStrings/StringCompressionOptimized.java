package ArraysAndStrings;

public class StringCompressionOptimized {
    private String compress(String str) {
        // checking the final length and return input string if it would be longer
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder(finalLength); // initialize capacity
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));   // append the current letter
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressed.toString();
    }

    private int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // if the index is the at the end of the string
            // OR
            // the current letter does not equal the next letter
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }

        return compressedLength;
    }
}
