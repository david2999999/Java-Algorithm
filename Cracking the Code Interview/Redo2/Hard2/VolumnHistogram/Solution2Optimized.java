package Hard2.VolumnHistogram;

public class Solution2Optimized {
    public int computeHistogramVolume(int[] histogram) {
        int start = 0;
        int end = histogram.length - 1;

        // create an array of data that contains the height of an index,
        // the index of the tallest bar on the right side of the current index
        // and the index of the tallest bar on the left side of the current index
        HistogramData[] data = createHistogramData(histogram);

        // finding the maximum bar in the whole histogram
        int max = data[0].getRightMaxIndex();

        // recursively find the volume on the left side
        int leftVolume = subgraphVolume(data, start, max, true);

        // recursively find the volume on the right side
        int rightVolume = subgraphVolume(data, max, end, false);

        // return the total volume
        return leftVolume + rightVolume;
    }

    private int subgraphVolume(HistogramData[] histogram, int start, int end, boolean isLeft) {
        if (start >= end) return 0;

        int sum = 0;
        if (isLeft) {   // finding the volume on the left side
            // finding the second tallest bar on the left side
            int max = histogram[end - 1].getLeftMaxIndex();

            // find the sum between the 2nd tallest bar and tallest bar
            sum += borderedVolume(histogram, max, end);

            // find the volume on the left side of the 2nd tallest bar
            sum += subgraphVolume(histogram, start, max, isLeft);
        } else { // finding the volume on the right side
            // find the 2nd tallest height on the right side
            int max = histogram[start + 1].getRightMaxIndex();

            // find the volume between tallest bar and the 2nd tallest bar
            sum += borderedVolume(histogram, start, max);

            // find the volume on the right side of the 2nd tallest bar
            sum += subgraphVolume(histogram, max, end, isLeft);
        }

        return sum;
    }

    private int borderedVolume(HistogramData[] data, int start, int end) {
        if (start >= end) return 0;

        // get the lower height of the 2 bars
        int min = Math.min(data[start].getHeight(), data[end].getHeight());
        int sum = 0;

        for (int i = start + 1; i < end; i++) {
            // the lower height - current height = volume
            sum += min - data[i].getHeight();
        }

        return sum;
    }

    private HistogramData[] createHistogramData(int[] histo) {
        HistogramData[] histogram = new HistogramData[histo.length];

        for (int i = 0; i < histo.length; i++) {
            histogram[i] = new HistogramData(histo[i]);
        }

        // set left max indexes
        int maxIndex = 0;
        for (int i = 0; i < histo.length; i++) {
            if (histo[maxIndex] < histo[i]) {
                maxIndex = i;
            }

            histogram[i].setLeftMaxIndex(maxIndex);
        }

        // set right max indexes
        maxIndex = histogram.length - 1;
        for (int i = histogram.length - 1; i >= 0; i--) {
            if (histo[maxIndex] < histo[i]) {
                maxIndex = i;
            }

            histogram[i].setRightMaxIndex(maxIndex);
        }

        return histogram;
    }
}
























