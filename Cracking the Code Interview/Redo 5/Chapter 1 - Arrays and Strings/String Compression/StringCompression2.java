public class StringCompression2 {
    public String compress(String str) {
        int compressedLength = countCompression(str);
        if (compressedLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder(compressedLength);

        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressed.toString();
    }

    private int countCompression(String str) {
        int countConsecutive = 0;
        int countCompressedLength = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                countCompressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }

        return countCompressedLength;
    }
}