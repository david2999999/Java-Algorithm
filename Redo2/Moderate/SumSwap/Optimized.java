package Moderate.SumSwap;

import java.util.HashSet;

// given two array of integers, find a pair of values (one from each array) that you
// can swap to give the two arrays the same sum
// Example:
// Input: {4, 1, 2, 1, 1, 2} and {3, 6, 3, 3}
// Output: {1, 3}
public class Optimized {
    // we need to find two values , a and b, such that
    // sumA - a + b = sumB - b + a
    // doing some quick math
    // sumA - sumB = 2a - 2b
    // a - b = (sumA - sumB) / 2

    // finding the sum of the array
    private int sum(int[] arr) {
        int sum = 0;
        for (int num: arr) {
            sum += num;
        }
        return sum;
    }

    // finding (sumA - sumB) / 2
    private Integer getTarget(int[] array1, int[] array2) {
        int sum1 = sum(array1);
        int sum2 = sum(array2);

        if ((sum1 - sum2) % 2 != 0) return null;    // if the difference is odd, we do not have a target
        return (sum1 - sum2) / 2;
    }

    public int[] findSwapValues(int[] array1, int[] array2) {
        Integer target = getTarget(array1, array2);
        if (target == null) return null;
        return findDifference(array1, array2, target);
    }

    private int[] findDifference(int[] array1, int[] array2, Integer target) {
        // storing all of the values from array2 into a HashSet, which allows O(1) lookup time
        HashSet<Integer> contents2 = getContents(array2);

        // target = (sumA - sumB) / 2
        // a - b = (sumA - sumB) / 2
        // a - b = target
        // a - target = b
        for (int one: array1) {
            int two = one - target; // a - target = b
            if (contents2.contains(two)) {  // if the second array contains the value we need
                int[] values = {one, two};
                return values;
            }
        }
        return null;    // did not find the 2 values
    }

    private HashSet<Integer> getContents(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int a: array) {
            set.add(a);
        }
        return set;
    }

    // Alternative solution if both of the arrays are already sorted
    public int[] findSwapValues2(int[] array1, int[] array2) {
        Integer target = getTarget(array1, array2);
        if (target == null) return null;    // invalid target
        return findDifference2(array1, array2, target);
    }

    private int[] findDifference2(int[] array1, int[] array2, Integer target) {
        int a = 0;  // index for array1
        int b = 0;  // index for array2

        while (a < array1.length && b < array2.length) {
            int difference = array1[a] - array2[b];

            if (difference == target) { // we have found our two values
                int[] values = { array1[a], array2[b] };
                return values;
            } else if (difference < target) {   // difference is too small, we need 'a' to be larger
                a++;
            } else {    // difference is too big, we need 'b' to be larger since a - b
                b++;
            }
        }

        return null;    // did not find the two values
    }
}


















