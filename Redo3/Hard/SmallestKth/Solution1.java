package Hard.SmallestKth;

import java.util.Arrays;

public class Solution1 {
    public int[] smallestK(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException("Invalid argument");
        }

        Arrays.sort(array);

        int[] smallest = new int[k];
        for (int i = 0; i < k; i++) {
            smallest[i] = array[i];
        }

        return smallest;
    }
}
