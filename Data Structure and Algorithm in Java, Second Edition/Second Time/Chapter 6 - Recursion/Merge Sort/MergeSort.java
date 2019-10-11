public class MergeSort {
    private int[] array;
    private int numberOfElements;

    public MergeSort(int max) {
        array = new int[max];
        numberOfElements = 0;
    }

    public void sort() {
        int[] workSpace = new int[numberOfElements];
        mergeSort(workSpace, 0, numberOfElements - 1);
    }

    private void mergeSort(int[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            mergeSort(workSpace, lowerBound, mid);
            mergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    private void merge(int[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int workSpaceIndex = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int numberOfElements = upperBound - lowerBound + 1;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (array[lowPtr] < array[highPtr]) {
                workSpace[workSpaceIndex++] = array[lowPtr++];
            } else {
                workSpace[workSpaceIndex++] = array[highPtr++];
            }
        }

        while (lowPtr <= mid) {
            workSpace[workSpaceIndex++] = array[lowPtr++];
        }

        while (highPtr <= upperBound) {
            workSpace[workSpaceIndex++] = array[highPtr++];
        }

        for (int i = 0; i < numberOfElements; i++) {
            array[lowerBound + i] = workSpace[i];
        }
    }
}