package Hard.ShortestSuperSequence;

public class Solution1 {
    private Range shortestSupersequence(int[] bigArray, int[] smallArray) {
        int bestStart = -1;
        int bestEnd = -1;

        for (int i = 0; i < bigArray.length; i++) {
            int end = findClosure(bigArray, smallArray, i);
            if (end == -1) break;

            if (bestStart == -1 || end - i < bestEnd - bestStart) {
                bestStart = i;
                bestEnd = end;
            }
        }

        return new Range(bestStart, bestEnd);
    }

    private int findClosure(int[] bigArray, int[] smallArray, int index) {
        int max = -1;
        for (int num: smallArray) {
            int next = findNextInstance(bigArray, num, index);
            if (next == -1) return -1;
            max = Math.max(max, next);
        }

        return max;
    }

    private int findNextInstance(int[] bigArray, int element, int index) {
        for (int i = index; i < bigArray.length; i++) {
            if (bigArray[i] == element) {
                return i;
            }
        }

        return -1;
    }
}
