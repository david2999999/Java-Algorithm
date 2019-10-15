public class HybridQuickSort {
    private long[] array;

    public void quickSort() {
        quickSort(0, array.length - 1);
    }

    private void quickSort(int left, int right) {
        int size = right - left + 1;
        if (size < 10) {
            insertionSort(left, right);
        } else {
            long median = medianOf3(left, right);
            int pivot = partition(left, right, median);
            quickSort(left, pivot - 1);
            quickSort(pivot + 1, right);
        }
    }

    private void insertionSort(int left, int right) {
        int inner, outer;

        for (outer = left + 1; outer <= right; outer++) {
            long temp = array[outer];
            inner = outer;

            while (inner > left && array[inner - 1] >= temp) {
                array[inner] = array[inner - 1];
                --inner;
            }

            array[inner] = temp;
        }
    }

    private int partition(int left, int right, long pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {
            while (array[++leftPtr] < pivot);
            while (array[--rightPtr] > pivot);

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }

            swap(leftPtr, right - 1);
            return leftPtr;
        }
    }

    private long medianOf3(int left, int right) {
        int center = (left + right) / 2;

        if (array[left] > array[center]) {
            swap(left, center);
        }

        if (array[left] > array[right]) {
            swap(left, right);
        }

        if (array[center] > array[right]) {
            swap(center, right);
        }

        swap(center, right - 1);
        return array[right - 1];
    }

    private void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1) {
            return;
        }

        if (size == 2) {
            if (array[left] > array[right]) {
                swap(left, right);
            }
            return;
        } else {
            if (array[left] > array[right - 1]) {
                swap(left, right - 1);
            }
            if (array[left] > array[right]) {
                swap(left, right);
            }
            if (array[right - 1] > array[right]) {
                swap(right - 1, right);
            }
        }
    }

    public void swap(int index1, int index2) {
        long temp;
        temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}