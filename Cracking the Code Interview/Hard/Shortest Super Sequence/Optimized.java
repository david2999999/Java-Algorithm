package Hard.ShortestSuperSequence;

public class Optimized {

    public Range shortestSupersequence(int[] big, int[] small) {
        int[][] nextElements = getNextElementsMulti(big, small);
        int[] closures = getClosures(nextElements);
        return getShortestClosure(closures);
    }

    private int[][] getNextElementsMulti(int[] big, int[] small) {
        int[][] nextElements = new int[small.length][big.length];
        for (int i = 0; i < small.length; i++) {
            nextElements[i] = getNextElement(big, small[i]);
        }

        return nextElements;
    }

    private int[] getNextElement(int[] bigArray, int value) {
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

    private int[] getClosures(int[][] nextElements) {
        int[] maxNextElement = new int[nextElements[0].length];

        for (int i = 0; i < nextElements[0].length; i++) {
            maxNextElement[i] = getClosureForIndex(nextElements, i);
        }

        return maxNextElement;
    }

    private int getClosureForIndex(int[][] nextElements, int index) {
        int max = -1;
        for (int i = 0; i < nextElements.length; i++) {
            if (nextElements[i][index] == -1)
                return -1;

            max = Math.max(nextElements[i][index], max);
        }

        return max;
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
}
