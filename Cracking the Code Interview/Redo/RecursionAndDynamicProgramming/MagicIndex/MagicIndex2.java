package Redo.RecursionAndDynamicProgramming.MagicIndex;

public class MagicIndex2 {
    private int getIndex(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        return getIndex(arr, 0, arr.length - 1);
    }

    private int getIndex(int[] arr, int start, int end) {
        if (end < start) return -1;

        int midIndex = (start + end) / 2;
        int midValue = arr[midIndex];

        if (midIndex == midValue) return midIndex;

        int leftIndex = Math.min(midIndex - 1, midValue);
        int leftValue = getIndex(arr, start, leftIndex);

        if (leftIndex >= 0) return leftIndex;

        int rightIndex = Math.max(midIndex + 1, midValue);
        int rightValue = getIndex(arr, rightIndex, end);

        return rightValue;
    }
}
