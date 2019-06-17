package Hard2.VolumnHistogram;

public class MostOptimized {
    public int computeHistogramVolume(int[] histo) {
        int[] leftMaxes = new int[histo.length];
        int leftMax = histo[0];

        // keeps track of the highest bar to the left of the current position
        for (int i = 0; i < histo.length; i++) {
            leftMax = Math.max(leftMax, histo[i]);
            leftMaxes[i] = leftMax;
        }

        // keeps track of the volume
        int sum = 0;

        int rightMax = histo[histo.length - 1];
        for (int i = histo.length - 1; i >= 0; i--) {
            // keeps track of the highest bar to the right of the current position
            rightMax = Math.max(rightMax, histo[i]);

            // get the 2nd tallest bar
            int secondTallest = Math.max(rightMax, leftMaxes[i]);


            if (secondTallest > histo[i]) {
                // finding the difference of the second tallest and the current height
                sum += secondTallest - histo[i];
            }
        }

        return sum;
    }
}













