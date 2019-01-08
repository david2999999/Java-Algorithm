package Moderate;

// given an array of integer, write a method to find indices m and n such that if you sorted
// elements m through n, the entire array will be sorted. Minimize n - m
// example:
// input: 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
// output: (3, 9)

// left < middle < right
public class SubSort {
    public void findUnsortedSequence(int[] array) {
        // find left subsequence
        int end_left = findEndOfLeftSubsequence(array);
        if (end_left >= array.length - 1) { // if the left section is greater or equal than the whole array
            return; // array already sorted
        }

        int start_right = findStartOfRightSubsequence(array);

        int max_index = end_left;   // max of left side
        int min_index = start_right;   // min of right side

        for (int i = end_left + 1; i < start_right; i++) {
            if (array[i] < array[min_index]) {
                min_index = i;  // found a smaller value in the middle section
            }

            if (array[i] > array[max_index]) {
                max_index = i;  // found a bigger value in the middle section
            }
        }
        
        // find the position in the left section that is smaller than the smallest value in the middle section
        int left_index = shrinkLeft(array, min_index, end_left);
        // find the position in the right section that is greater than the greatest value in the middle section
        int right_index = shrinkRight(array, max_index, start_right);

        // found the two indexes that needs to be sorted, in order for the whole array to be sorted
        System.out.println(left_index + " " + right_index);
    }

    private int shrinkRight(int[] array, int max_index, int start) {
        int comp = array[max_index];
        for (int i = start; i < array.length; i++) {
            if (array[i] >= comp) return i - 1;
        }

        return array.length - 1;
    }

    private int shrinkLeft(int[] array, int min_index, int start) {
        int comp = array[min_index];
        for (int i = start - 1; i >= 0; i--) {
            if (array[i] <= comp) {
                return i + 1;   // found a smaller value in the left section
            }
        }
        return 0;
    }

    private int findStartOfRightSubsequence(int[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            // if the previous element is greater than the next element
            if (array[i] > array[i + 1]) return i + 1;
        }

        return 0;   // the array is already sorted
    }

    private int findEndOfLeftSubsequence(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // if the next element is smaller than the previous element
            // we have found our middle section
            if (array[i] < array[i - 1]) return i - 1;
        }

        return array.length - 1;    // the whole array is in sorted order
    }
}
