public class SelectionSort {
    private long[] a;
    private int nElems;

    public void sort() {
        int min;

        for (int out = 0; out < nElems - 1; out++) {
            min = out;

            for (int in = out + 1; in < nElems; in++) {
                if (a[in] < a[min]) {
                    min = in;
                }
            }

            swap(out, min);
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}