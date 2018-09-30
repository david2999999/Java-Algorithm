package Redo.Moderate;

public class Subsort {
    private void findUnsorted(int[] arr) {
        int end_left = findEndOfLeftMostIndex(arr);
        if (end_left >= arr.length - 1) return;

        int start_right = findStartOfRightMostIndex(arr);

        int min_index = start_right;
        int max_index = end_left;

        for (int i = end_left + 1; i < start_right; i++) {
            if (arr[i] < arr[min_index]) min_index = i;
            if (arr[i] > arr[max_index]) max_index = i;
        }

        int left_index = shrinkLeft(arr, min_index, end_left);
        int right_index = shrinkRight(arr, max_index, start_right);

        System.out.println(left_index + " " + right_index);
    }

    private int findEndOfLeftMostIndex(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return i - 1;
            }
        }

        return arr.length - 1;
    }

    private int findStartOfRightMostIndex(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                return i + 1;
            }
        }

        return 0;
    }

    private int shrinkLeft(int[] arr, int min_index, int start) {
        int comp = arr[min_index];

        for (int i = start - 1; i >= 0; i--) {
            if (arr[i] <= comp) {
                return i + 1;
            }
        }

        return 0;
    }

    private int shrinkRight(int[] arr, int max_index, int start) {
        int comp = arr[max_index];

        for (int i = start; i < arr.length; i++) {
            if (arr[i] >= comp) {
                return i - 1;
            }
        }

        return arr.length - 1;
    }
}
