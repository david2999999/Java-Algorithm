package Hard2.SmallestK;

import java.util.Arrays;

// Design an algorithm to find the smallest K numbers in an array
public class Sorting {
    // this example, we will sort the array first, then find the smallest K elements
    public int[] smallestK(int[] array, int k) {
        if (k <= 0 || k > array.length) {   // illegal k value
            throw new IllegalArgumentException();
        }

        Arrays.sort(array); // sort the array O(n log n)

        int[] smallest = new int[k];    // array to hold the smallest k elements
        for (int i = 0; i < k; i++) {   // O(n)
            smallest[i] = array[i]; // copy the elements over
        }

        return smallest;    // return smallest array
    }

    // the time complexity of this method is O(n log n) + O(n) = O(n log n)
}
