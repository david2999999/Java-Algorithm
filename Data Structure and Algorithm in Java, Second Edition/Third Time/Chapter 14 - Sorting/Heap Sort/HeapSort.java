public class HeapSort {
    public void sort(int[] arr) {
        int length = arr.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(a, i, n);
        }

        for (int i = length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    private void heapify(int[] arr, int start, int end) {
        int current = arr[start];

        while (2 * start + 1 < end) {
            int largerChildIndex = 2 * start + 1;

            if (largerChildIndex + 1 < end && arr[largerChildIndex + 1] > arr[largerChildIndex]) {
                ++largerChildIndex;
            }

            if (current >= arr[largerChildIndex]) {
                break;
            }

            arr[start] = a[largerChildIndex];
            start = largerChildIndex;
        }

        a[start] = current;
    }
}