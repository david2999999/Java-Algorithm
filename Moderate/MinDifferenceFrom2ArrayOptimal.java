package Moderate;

import java.util.Arrays;

public class MinDifferenceFrom2ArrayOptimal {
    private int findMinDifference(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);

        int a = 0;
        int b = 0;
        int difference = Integer.MAX_VALUE;

        while (a < array1.length && b < array2.length) {
            if (Math.abs(array1[a] - array2[b]) < difference) {
                difference = Math.abs(array1[a] - array2[b]);
            }

            if (array1[a] < array2[b]) {
                a++;
            } else {
                b++;
            }
        }

        return difference;

    }
}
