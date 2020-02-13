public class KMP {
    public int findKMP(char[] text, char[] pattern) {
        int textLength = text.length;
        int patternLength = pattern.length;

        if (patternLength == 0) return 0;

        int[] failTable(pattern);

        int j = 0;
        int k = 0;

        while (j < n) {
            if (text[j] == pattern[k]) {
                if (k == patternLength - 1) {
                    return j - patternLength + 1;
                }

                k++;
                j++;
            } else if (k > 0) {
                k = failTable[k - 1];
            } else {
                j++;
            }
        }

        return -1;
    }


    private int[] computeKMPFunction(char[] pattern) {
        int patternLength = pattern.length;
        int[] fail = new int[patternLength];

        int j = 1;
        int k = 0;

        while (j < m) {
            if (pattern[j] == pattern[k]) {
                fail[j] = k + 1;
                j++;
                k++;
            } else if (k > 0) {
                k = fail[k - 1];
            } else {
                j++;
            }
        }

        return fail;
    }
}