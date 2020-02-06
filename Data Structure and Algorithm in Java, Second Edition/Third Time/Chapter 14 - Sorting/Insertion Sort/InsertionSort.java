public class InsertionSort {
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int current = a[i], j;

            for (j = i; j > 0 && a[j - 1] > current; j--) {
                a[j] = a[j - 1];
            }

            a[j] = current;
        }
    }
}