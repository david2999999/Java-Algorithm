package Hard.VolumeOfHistogram;

public class Solution3 {
    private int computeHistogramVolume(int[] histo) {
        int[] leftMaxes = new int[histo.length];
        int leftMax = histo[0];

        for (int i = 0 ; i < histo.length; i++) {
            leftMax = Math.max(leftMax, histo[i]);
            leftMaxes[i] = leftMax;
        }

        int sum = 0;

        int rightMax = histo[histo.length - 1];
        for (int i = histo.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, histo[i]);
            int secondTallest = Math.min(rightMax, leftMaxes[i]);

            if (secondTallest > histo[i]) {
                sum += secondTallest - histo[i];
            }
        }

        return sum;
    }
}
