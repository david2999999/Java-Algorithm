package Moderate;

// given an array of integers (both positive and negative)
// find the contiguous sequence with the largest sum, return the sum
// Example
// Input: {2, -8, 3, -2, 4, -10}
// Output: 5 (i.e., {3, -2, 4})
public class MaximumContiguousSequence {
    public int getmaxSum(int[] a) {
        int maxSum = 0; // tracking the maximum sum
        int sum = 0;    // tracking the current sum

        for (int i = 0; i < a.length; i++) {
            sum += a[i];    // add the current value to the current sum

            if (maxSum < sum) { // if the maximum sum is smaller than the current sum
                maxSum = sum;   // update the maximum sum
            } else if (sum < 0) {
                // if the current sum ever gets to a negative value
                // reset the sum
                sum = 0;
            }
        }

        return maxSum;  // the maximum sum
    }
}
