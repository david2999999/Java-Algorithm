package Hard.ShortestSuperSequence;

public class BruteForce {

    public Range shortestSupersequence(int[] bigArray, int[] smallArray) {
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
        for (int i = 0; i < smallArray.length; i++) {
            int next = findNextInstance(bigArray, smallArray[i], index);
            if (next == -1) {
                return -1;
            }

            max = Math.max(max, next);
        }

        return max;
    }

    private int findNextInstance(int[] array, int element, int index) {
        for (int i = index; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }

        return -1;
    }
}
