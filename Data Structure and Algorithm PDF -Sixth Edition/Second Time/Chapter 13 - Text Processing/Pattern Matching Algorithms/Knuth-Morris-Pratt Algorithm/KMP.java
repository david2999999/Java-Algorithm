public class KMP {

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