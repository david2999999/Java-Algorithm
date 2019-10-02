package Sorting;

public class BubbleSort {
    private void sort(int ar[]) {
        for (int i = ar.length; i >= 0; i--) {
            for (int j = 1; j < ar.length; j++) {
                if (ar[j - 1] > ar[j]) {
                    int temp = ar[j - 1];
                    ar[j - 1] = ar[j];
                    ar[j] = temp;
                }
            }
        }
    }
}
