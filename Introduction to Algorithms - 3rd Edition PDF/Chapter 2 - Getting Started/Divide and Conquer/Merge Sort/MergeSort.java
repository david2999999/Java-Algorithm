public class mergeSort {
    public static void main(String[] args) {
        int[] arr = {
                23, 124, 125, 123, 512, 21, 42, 52, 199
        };

        int low = 0;
        int high = arr.length;
        int mid = (low + high) / 2;

        merge(arr, low, mid, high);
    }

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public void merge(int[] arr, int low, int mid, int high) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        int[] leftArray = new int[leftSize + 1];
        int[] rightArray = new int[rightSize + 1];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = arr[low + i];
        }

        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = arr[mid + j + 1];
        }

        leftArray[leftSize] = Integer.MAX_VALUE;
        rightArray[rightSize] = Integer.MAX_VALUE;

        int leftIndex = 0;
        int rightIndex = 0;

        for (int k = low; k <= high; k++) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                arr[k] = leftArray[leftIndex];
                leftIndex++;
            } else {
                arr[k] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}