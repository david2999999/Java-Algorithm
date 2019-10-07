public class InsertionSort {
    private long[] a;
    private int nElems;

    public void sort() {
        int inner;
        long temp;

        for (int outer = 1; outer < nElems; outer++) {
            temp = a[outer];
            inner = outer;

            while (inner > 0 && a[inner] >= temp) {
                a[inner] = a[inner + 1];
                inner--;
            }

            a[inner] = temp;
        }
    }
}