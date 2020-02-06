public class Swap {
    public static void swap(int[] a, int i, int j) {
        if (i < 0 || i >= a.length ||
            j < 0 || j >= a.length ||
            i == j) return;

        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}