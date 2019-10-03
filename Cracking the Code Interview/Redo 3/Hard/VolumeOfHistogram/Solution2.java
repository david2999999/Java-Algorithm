package Hard.VolumeOfHistogram;

public class Solution2 {
    private int computeHistogramVolume(int[] histogram) {
        int start = 0;
        int end = histogram.length - 1;

        HistogramData[] data = createHistogramData(histogram);

        int max = data[0].getRightMaxIndex();
        int leftVolume = subgraphVolume(data, start, max, true);
        int rightVolume = subgraphVolume(data, max, end, false);

        return leftVolume + rightVolume;
    }

    private int subgraphVolume(HistogramData[] histogram, int start, int end, boolean isLeft) {
        if (start >= end) return 0;

        int sum = 0;
        if (isLeft) {
            int max = histogram[end - 1].getLeftMaxIndex();
            sum += borderedVolume(histogram, max, end);
            sum += subgraphVolume(histogram, start, max, isLeft);
        } else {
            int max = histogram[start + 1].getRightMaxIndex();
            sum += borderedVolume(histogram, start, max);
            sum += subgraphVolume(histogram, max, end, isLeft);
        }

        return sum;
    }

    private int borderedVolume(HistogramData[] data, int start, int end) {
        if (start >= end) return 0;

        int min = Math.min(data[start].getHeight(), data[end].getHeight());
        int sum = 0;
        for (int i = start + 1; i < end; i++) {
            sum += min - data[i].getHeight();
        }

        return sum;
    }

    private HistogramData[] createHistogramData(int[] histo) {
        HistogramData[] histogram = new HistogramData[histo.length];

        for (int i = 0; i < histo.length; i++) {
            histogram[i] = new HistogramData(histo[i]);
        }

        int maxIndex = 0;
        for (int i = 0; i < histo.length; i++) {
            if (histo[maxIndex] < histo[i]) {
                maxIndex = i;
            }

            histogram[i].setLeftMaxIndex(maxIndex);
        }

        maxIndex = histo.length - 1;
        for (int i = histo.length - 1; i >= 0; i--) {
            if (histo[maxIndex] < histo[i]) {
                maxIndex = i;
            }

            histogram[i].setRightMaxIndex(maxIndex);
        }

        return histogram;
    }
}
