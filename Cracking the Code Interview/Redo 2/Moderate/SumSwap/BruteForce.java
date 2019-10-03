package Moderate.SumSwap;

// given two array of integers, find a pair of values (one from each array) that you
// can swap to give the two arrays the same sum
// Example:
// Input: {4, 1, 2, 1, 1, 2} and {3, 6, 3, 3}
// Output: {1, 3}
public class BruteForce {
    // we need to find two values , a and b, such that
    // sumA - a + b = sumB - b + a
    // doing some quick math
    // sumA - sumB = 2a - 2b
    // a - b = (sumA - sumB) / 2

    // Brute force method
    public int[] findSwapValues(int[] array1, int[] array2) {
        // finding the sum of each array
        int sum1 = sum(array1);
        int sum2 = sum(array2);

        for (int one: array1) {
            for (int two: array2) {
                int newSum1 = sum1 - one + two; // sumA - a + b
                int newSum2 = sum2 - two + one; // sumB - b + a

                if (newSum1 == newSum2) {   // sumA - a + b == sumB - b + a
                    int[] values = { one, two };
                    return values;
                }
            }
        }

        return null;    // did not find the two values
    }

    private int sum(int[] arr) {
        int sum = 0;
        for (int num: arr) {
            sum += num;
        }
        return sum;
    }


    // this is the brute force target approach
    // finding (sumA - sumB) / 2
    public int[] findSwapValues2(int[] array1, int[] array2) {
        Integer target = getTarget(array1, array2);
        if (target == null) return null;    // unable to find the pair of values


        for (int one : array1) {
            for (int two: array2) {
                if (one - two == target) { // a - b == (sumA - sumB) / 2
                    int[] values = {one, two}; // {a, b}
                    return values;
                }
            }
        }

        return null;    // did not find the two pairs
    }

    private Integer getTarget(int[] array1, int[] array2) {
        int sum1 = sum(array1);
        int sum2 = sum(array2);

        if ((sum1 - sum2) % 2 != 0) return null;    // if the difference is odd, we do not have a target
        return (sum1 - sum2) / 2;
    }

}






















