package Hard2.SubSequence;

public class Optimized {
    public Range shortestSuperSequence(int[] big, int[] small) {
        int[][] nextElements = getNextElementsMulti(big, small);
        int[] closures = getClosures(nextElements);
        return getShortestClosure(closures);
    }

    private Range getShortestClosure(int[] closures) {
        int bestStart = -1;
        int bestEnd = -1;

        for (int i = 0; i < closures.length; i++) {
            if (closures[i] == -1) {    // there are no more closures
                break;
            }

            // end index - start index
            int current = closures[i] - i;

            // if we haven't have a starting location or if the current length is shorter than the best length
            if (bestStart == -1 || current < bestEnd - bestStart) {
                bestStart = i;
                bestEnd = closures[i];
            }
        }

        // return the shortest length of the subarray
        return new Range(bestStart, bestEnd);
    }

    private int[] getClosures(int[][] nextElements) {
        // keeps track of the maximum value at each column
        int[] maxNextElements = new int[nextElements[0].length];

        // loop through all of the columns
        for (int i = 0; i < nextElements[0].length; i++) {
            // find the maximum value for the column
            maxNextElements[i] = getClosuresForIndex(nextElements, i);
        }
        return maxNextElements;
    }

    private int getClosuresForIndex(int[][] nextElements, int index) {
        int max = -1;
        // loop through each of the rows
        for (int i = 0; i < nextElements.length; i++) {
            if (nextElements[i][index] == -1) { // there is no maximum index
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
        // -1 means the value has not appeared yet
        int next = -1;

        // creating an array to keep track all of the previous index of the value
        int[] nexts = new int[bigArray.length];

        // start from the end of the big array
        for (int i = bigArray.length - 1; i >= 0; i--) {
            if (bigArray[i] == value) {
                next = i;   // found the element, update the index
            }

            nexts[i] = next;
        }

        return nexts;
    }
}











