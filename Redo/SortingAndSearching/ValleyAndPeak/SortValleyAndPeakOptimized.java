package Redo.SortingAndSearching.ValleyAndPeak;

public class SortValleyAndPeakOptimized {
    private void sort(int[] arr) {
        for (int i = 1; i < arr.length; i += 2) {
            int index = maxIndex(arr, i - 1, i, i + 1);
            if (index != i) {
                swap(arr, index, i);
            }
        }
    }

    private int maxIndex(int[] arr, int a, int b, int c) {
        int len = arr.length;
        int valueA = a >= 0 && a < len ? arr[a] : Integer.MIN_VALUE;
        int valueB = b >= 0 && b < len ? arr[b] : Integer.MIN_VALUE;
        int valueC = c >= 0 && c < len ? arr[c] : Integer.MIN_VALUE;

        int maxValue = Math.max(valueA, Math.max(valueB, valueC));
        if (maxValue == valueA) return a;
        else if (maxValue == valueB) return b;
        return c;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
