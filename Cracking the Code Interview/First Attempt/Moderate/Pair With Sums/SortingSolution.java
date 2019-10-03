package Moderate.PairWithSums;

import java.util.Arrays;

public class SortingSolution {
    private void printSums(int[] array, int sum) {
        Arrays.sort(array);
        int first = 0;
        int end = array.length - 1;

        while (first < end) {
            int s = array[first] + array[end];

            if (s == sum) {
                System.out.println(array[first] + " " + array[end]);
                first++;
                end--;
            } else {
                if ( s < sum ) {
                    first++;
                } else {
                    end--;
                }
            }
        }
    }
}
