public class InsertionSort {
    // Sort an array using a simple insertion sort.
    public static void sort( int[] data ) {
        for (int which = 1; which < data.length; ++which) {
            int val = data[which];
            for (int i = which - 1; i >= 0; --i) {
                if (data[i] > val) {
                    data[i + 1] = data[i];
                    data[i] = val;
                } else {
                    break;
                }
            }
        }
    }
}