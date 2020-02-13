public class BruteForceSearch {
    public int search(char[] text, char[] pattern) {
        int textLength = text.length;
        int patternLength = pattern.length;

        for (int i = 0; i <= textLength - patternLength; i++) {
            int k = 0;

            while (k < patternLength && text[i + k] == pattern[k]) {
                k++;
            }

            if (k == patternLength) {
                return i;
            }
        }

        return -1;
    }
}