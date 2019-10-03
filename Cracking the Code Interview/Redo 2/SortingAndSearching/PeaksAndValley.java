package SortingAndSearching;

import java.lang.reflect.Array;
import java.util.Arrays;

// given an array of integers,
// a peak is an element which is greater than or equal to the adjacent integers
// a valley is an element which is less than or equal to the adjacent integer
// give an array of integers, sort the array into an alternating sequence of peaks and valley
// ex:
// input: {5, 3, 1, 2, 3}
// output: { 5, 1, 3, 2, 3}
public class PeaksAndValley {
    // the suboptimal way of finding the solution
    // is sorting the array in ascending order
    // then iterate through the elements, starting from index 1, then jumping two elements at a time
    // then swapping each element with the previous element
    // for example:
    // if you sorted an array to {1, 4, 6, 7, 8, 10}
    // then iterate starting from index 1 and swapping with previous elements
    // you get {4, 1, 7, 6, 10, 8}

    public void sortValleyPeak(int[] array) {
        Arrays.sort(array);
        for (int i = 1; i < array.length; i += 2) {
            swap(array, i - 1, i);  // swapping the current element with the previous element
        }
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    // since this suboptimal solution requires sorting, it is O(n log n)

    // for a more optimal solution, we have to find an answer without sorting
    // since this method does not require sorting and just need to iterate over the list once
    // this example will run in O(n)
    public void sortValleyPeak2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int biggestIndex = maxIndex(array, i - 1, i, i + 1);    // finding the index of the biggest value
            if (i != biggestIndex) {    // if the element in the middle index is not the highest value
                swap(array, i, biggestIndex);   // this will make sure the peak is always the middle index
            }
        }
    }

    private int maxIndex(int[] array, int a, int b, int c) {
        int len = array.length;

        // the MIN_VALUE is used when index out of bound
        int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;

        int max = Math.max(aValue, Math.max(bValue, cValue));   // finding the largest value out of the three

        // returning the index of the largest value
        if (aValue == max) {
            return a;
        } else if (bValue == max) {
            return b;
        } else {
            return c;
        }
    }


}



























