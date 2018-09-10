package Moderate;

public class SubSort {
    private void findUnsortedSequence(int[] array) {
        int end_left = findEndOfLeftSequence(array);
        if (end_left >= array.length - 1) return;

        int start_right = findStartOfRightSequence(array);

        int max_index = end_left;
        int min_index = start_right;

        for (int i = min_index + 1; i < max_index; i++) {
            if (array[i] > array[max_index]) max_index = i;
            if (array[i] < array[min_index]) min_index = i;
        }

        int left_index = shrinkLeft(array, min_index, end_left);
        int right_index = shrinkRight(array, max_index, start_right);

        System.out.println(left_index + " " + right_index);
    }

    private int findEndOfLeftSequence(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                return i - 1;
            }
        }

        return array.length - 1;
    }

    private int findStartOfRightSequence(int[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] > array[i + 1]) {
                return i + 1;
            }
        }

        return 0;
    }

    private int shrinkLeft(int[] array, int minIndex, int start) {
        int comp = array[minIndex];

        for (int i = start - 1; i >= 0; i--) {
            if (array[i] <= comp) return i + 1;
        }

        return 0;
    }

    private int shrinkRight(int[] array, int maxIndex, int start) {
        int comp = array[maxIndex];

        for (int i = start; i < array.length; i++) {
            if (array[i] >= comp) return i - 1;
        }

        return array.length - 1;
    }
}
