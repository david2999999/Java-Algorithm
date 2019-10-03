package Hard.ShortestSuperSequence;

public class Solution2 {
    private Range shortestSuperSequence(int[] big, int[] small) {
        int[][] nextElements = getNextElementsMulti(big, small);
        int[] closures = getClosures(nextElements);
        return getShortestClosure(closures);
    }

    private Range getShortestClosure(int[] closures) {
        int bestStart = -1;
        int bestEnd = -1;

        for (int i = 0; i < closures.length; i++) {
            if (closures[i] == -1) break;
            int current = closures[i] - i;
            if (bestStart == -1 || current < bestEnd - bestStart) {
                bestStart = i;
                bestEnd = closures[i];
            }
        }

        return new Range(bestStart, bestEnd);
    }

    private int[] getClosures(int[][] nextElements) {
        int[] maxNextElements = new int[nextElements[0].length];
        for (int i = 0; i < nextElements[0].length; i++) {
            maxNextElements[i] = getClosureForIndex(nextElements, i);
        }

        return maxNextElements;
    }

    private int getClosureForIndex(int[][] nextElements, int index) {
        int max = -1;
        for (int i = 0; i < nextElements.length; i++) {
            if (nextElements[i][index] == -1) {
                return -1;
            }

            max = Math.max(max, nextElements[i][index]);
        }

        return max;
    }

    private int[][] getNextElementsMulti(int[] big, int[] small) {
        int[][] nextElements = new int[small.length][big.length];
        for (int i = 0; i < small.length; i++) {
            nextElements[i] = getNextElements(big, small[i]);
        }

        return nextElements;
    }

    private int[] getNextElements(int[] bigArray, int value) {
        int next = -1;
        int[] nexts = new int[bigArray.length];

        for (int i = bigArray.length - 1; i >= 0; i--) {
            if (bigArray[i] == value) {
                next = i;
            }

            nexts[i] = next;
        }

        return nexts;
    }
}
