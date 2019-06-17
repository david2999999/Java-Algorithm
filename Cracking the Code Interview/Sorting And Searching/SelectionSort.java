package Sorting;

public class SelectionSort {
    private void sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = 0;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
