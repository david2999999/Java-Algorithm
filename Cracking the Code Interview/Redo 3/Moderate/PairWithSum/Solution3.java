package Moderate.PairWithSum;

import java.util.Arrays;

public class Solution3 {
    public void printPairSums(int[] array, int sum) {
        Arrays.sort(array);
        int first = 0;
        int last = array.length - 1;

        while (first < last) {
            int s = array[first] + array[last];
            if (s == sum) {
                System.out.println(array[first] + " " + array[last]);
                first++;
                last--;
            } else {
                if (s < sum) first++;
                else last--;
            }
        }
    }
}
