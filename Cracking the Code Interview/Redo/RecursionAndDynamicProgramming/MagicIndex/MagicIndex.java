package Redo.RecursionAndDynamicProgramming.MagicIndex;

public class MagicIndex {
    private int findIndex(int[] arr) {
        return getMagicIndex(arr, 0, arr.length - 1);
    }

    private int getMagicIndex(int[] arr, int start, int end) {
        if (end < start) return -1;

        int mid = (start + end) / 2;

        if (arr[mid] == mid) {
            return mid;
        } else if (arr[mid] > mid) {
            return getMagicIndex(arr, start, mid - 1);
        } else {
            return getMagicIndex(arr, mid + 1, end);
        }
    }
}
