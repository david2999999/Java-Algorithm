public class InsertionSort {
    private Person[] a;
    private int nElems;

    public void sort() {
        int inner;
        Person temp;

        for (int outer = 1; outer < nElems; outer++) {
            temp = a[outer];
            inner = outer;

            while (inner > 0 && a[inner - 1].getLast().compareTo(temp.getLast()) > 0) {
                a[inner] = a[inner - 1];
                --inner;
            }

            a[inner] = temp;
        }
    }
}