package Hard.LettersAndNumbers;

import java.util.HashMap;

public class Solution2 {
    private char[] findLongestSubarray(char[] array) {
        int[] deltas = computeDeltaArray(array);
        int[] match = findLongestMatch(deltas);
        return extractSubarray(array, match[0] + 1, match[1]);
    }

    private char[] extractSubarray(char[] array, int start, int end) {
        char[] subarray = new char[end - start + 1];
        for (int i = start; i <= end; i++) {
            subarray[i - start] = array[i];
        }

        return subarray;
    }

    private int[] findLongestMatch(int[] deltas) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int[] max = new int[2];

        for (int i = 0; i < deltas.length; i++) {
            if (!map.containsKey(deltas[i])) {
                map.put(deltas[i], i);
            } else {
                int match = map.get(deltas[i]);
                int distance = i - match;
                int longest = max[1] - max[0];
                if (distance > longest) {
                    max[1] = i;
                    max[0] = distance;
                }
            }
        }

        return max;
    }

    private int[] computeDeltaArray(char[] array) {
        int[] deltas = new int[array.length];
        int delta = 0;

        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i])) {
                delta++;
            } else if (Character.isDigit(array[i])) {
                delta--;
            }

            deltas[i] = delta;
        }

        return deltas;
    }
}
