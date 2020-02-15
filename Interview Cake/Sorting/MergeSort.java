public class MergeSort {
    public int[] sort(int[] arrayToSort) {
        if (arrayToSort.length < 2) {
            return arrayToSort;
        }

        int midIndex = arrayToSort.length / 2;

        int[] left = Arrays.copyOfRange(arrayToSort, 0, midIndex);
        int[] right = Arrays.copyOfRange(arrayToSort, midIndex, arrayToSort.length);

        int[] sortedLeft = sort(left);
        int[] sortedRight = sort(right);

        return merge(sortedLeft, sortedRight);
    }

    private int[] merge(int[] sortedLeft, int[] sortedRight) {
        int[] sortedArray = new int[sortedLeft.length + sortedRight.length];

        int currentLeftIndex = 0;
        int currentRightIndex = 0;

        for (int currentSortedIndex = 0; currentSortedIndex < sortedArray.length; currentSortedIndex++) {
            if (currentLeftIndex < sortedLeft.length
                    && (currentRightIndex >= sortedRight.length || sortedLeft[currentLeftIndex] < sortedRight[currentRightIndex])) {
                sortedArray[currentSortedIndex++] = sortedLeft[currentLeftIndex++];
            } else {
                sortedArray[currentSortedIndex++] = sortedRight[currentRightIndex++];
            }
        }

        return sortedArray;
    }
}

// So what's our total time cost? O(nlog2n).
// The log_{2}{n} comes from the number of times we have to cut n
// in half to get down to subarrays of just 1 element (our base case).
// The additional nn comes from the time cost of merging all n items
// together each time we merge two sorted subarrays.