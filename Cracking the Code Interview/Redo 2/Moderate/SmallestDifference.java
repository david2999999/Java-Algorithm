package Moderate;

import java.util.Arrays;

// give two array of integers, compute the the pair of values with the smallest non-negative difference
// return the difference
public class SmallestDifference {
    // brute force approach is to loop over both of the arrays and find the minimum difference
    // since we are using 2 for loops
    // the O(n) for the brute force method is O(AB)
    // where A is the length of the first array
    // and B is the length of the second array
    public int findSmallestDifferenceBruteForce(int[] array1, int[] array2) {
        if (array1.length == 0 || array2.length == 0) return -1;    // invalid arrays

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (Math.abs(array1[i] - array2[j]) < min) {    // if the current min is less than previous min
                    min = Math.abs(array1[i] - array2[j]);  // set a new minimum difference
                }
            }
        }

        return min; // minimum difference
    }

    // a more optimized method to sort both of the arrays first, then find the minimum difference
    public int findSmallestDifferenceOptimized(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);

        int a = 0;  // tracking the index of array1
        int b = 0;  // tracking the index of array2
        int difference = Integer.MAX_VALUE;

        while (a < array1.length && b < array2.length) {
            if (Math.abs(array1[a] - array2[b]) < difference) { // if we found a lower difference
                difference = Math.abs(array1[a] - array2[b]);
            }

            // we want to move the smaller value to minimize the minimum difference
            if (array1[a] < array2[a]) {
                a++;
            } else {
                b++;
            }
        }

        return difference;  // return minimum difference
    }
}



















