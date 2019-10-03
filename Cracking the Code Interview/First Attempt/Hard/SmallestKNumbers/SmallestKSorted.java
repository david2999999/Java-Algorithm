package Hard.SmallestKNumbers;

import java.util.Arrays;

public class SmallestKSorted {
    public int[] smallest(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(array);

        int[] smallest = new int[k];
        for (int i = 0; i < k; i++) {
            smallest[i] = array[i];
        }

        return smallest;
    }
}
