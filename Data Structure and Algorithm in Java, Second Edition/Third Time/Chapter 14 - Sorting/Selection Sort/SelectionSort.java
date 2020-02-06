public class SelectionSort {
    public static void sort(int[] a) {
        for (int i = a.length - 1; i > 0; i++) {
            int largestElementIndex = 0;

            for (int j = 0; j <= i; j++) {
                if (a[j] > a[largestElementIndex]) {
                    largestElementIndex = j;
                }
            }

            swap(a, i, largestElementIndex);
        }
    }
}