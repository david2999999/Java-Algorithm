package Hard2.VolumnHistogram;

public class Solution1 {
    public int computeHistogram(int[] histogram) {
        int start = 0;
        int end = histogram.length - 1;

        // find the index of the column with maximum height in the histogram with range from start -> end
        int max = findIndexOfMax(histogram, start, end);

        int leftVolume = subgraphVolume(histogram, start, max, true);
        int rightVolume = subgraphVolume(histogram, max, end, false);

        return leftVolume + rightVolume;
    }

    private int subgraphVolume(int[] histogram, int start, int end, boolean isLeft) {
        if (start >= end) return 0;

        int sum = 0;
        if (isLeft) {
            int max = findIndexOfMax(histogram, start, end - 1);
            // find the volume where the end is the max index
            // calculates volume on the right side
            sum += borderedVolume(histogram, max, end);

            // calculate volume on the left side
            // recursively calculate the volume on the left side
            sum += subgraphVolume(histogram, start, end, isLeft);
        } else {    // calculating the volume on the right side
            int max = findIndexOfMax(histogram, start + 1, end);

            // start contains the tallest bar
            // max contains the second tallest bar
            sum += borderedVolume(histogram, start, max);

            // recursively find the volume on the right side
            sum += subgraphVolume(histogram, max, end, isLeft);
        }

        return sum;
    }

    // compute the volume from start to end, assuming the tallest bar is at the start
    // and the second tallest is start
    private int borderedVolume(int[] histogram, int start, int end) {
        if (start >= end) return 0;

        // find the smaller height of the two bars
        int min = Math.min(histogram[start], histogram[end]);
        int sum = 0;

        // loop through the indexes
        for (int i = start + 1; i < end; i++) {
            // the volume at each index is
            // the height of the second tallest bar - the height at each index
            sum += min - histogram[i];
        }

        return sum;
    }

    private int findIndexOfMax(int[] histogram, int start, int end) {
        int indexOfMax = start;
        for (int i = start + 1; i < end; i++) {
            if (histogram[i] > histogram[indexOfMax]) {
                indexOfMax = i;
            }
        }

        return indexOfMax;
    }
}
