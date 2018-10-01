package Redo.Moderate;

public class LargestContiguousSum {
    private int findLargestSum(int[] arr) {
        int sum = 0;
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > maxSum) {
                maxSum = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }
}
