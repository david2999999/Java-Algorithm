package Sorting;

public class InsertionSort {
    private void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int index = arr[i];
            int j = i;

            while (j > 0 && arr[j - 1] > index) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = index;
        }
    }
}
