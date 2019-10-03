package Moderate;

public class MaximumSumInContiguousSequence {
    private int getMaxSum(int[] a) {
        int maxSum = 0;
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];

            if (sum > maxSum) {
                maxSum = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }
}
