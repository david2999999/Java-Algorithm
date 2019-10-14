public class QuickSort {
    private long[] array;

    public void quickSort(int left, int right) {
        if (left >= right) return;
        else {
            long pivot = array[right];
            int partition = partition(left, right, pivot);
            quickSort(left, partition - 1);
            quickSort(right, partition + 1);
        }
    }

    private int partition(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;

        while (true) {
            while (array[++leftPtr] < pivot) ;
            while (rightPtr > 0 && array[--rightPtr] > pivot) ;

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }

        swap(leftPtr, right);
        return leftPtr;
    }

    public void swap(int index1, int index2) {
        long temp;
        temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}