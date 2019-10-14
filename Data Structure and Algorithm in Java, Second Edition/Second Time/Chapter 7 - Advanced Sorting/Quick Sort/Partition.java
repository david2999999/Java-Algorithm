public class Partition {
    private long[] array;

    public int partition(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;

        while (true) {
            while (leftPtr < right && this.array[++leftPtr] < pivot) ;
            while (rightPtr > left && this.array[--rightPtr] > pivot) ;

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }

        return leftPtr;
    }

    public void swap(int index1, int index2) {
        long temp;
        temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}