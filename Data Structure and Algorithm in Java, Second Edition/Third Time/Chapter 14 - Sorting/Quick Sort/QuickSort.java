public class QuickSort {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    private void sort(int[] arr, int low, int high) {
        if (high - low < 2) return;

        int pivot = partition(arr, low, high);
        sort(arr, low, pivot);
        sort(arr, pivot + 1, high);
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low], left = low, right = high;

        while (left < right) {
            while (left < right && arr[--right] >= pivot)
                ;

            if (left < right) {
                arr[left] = arr[right];
            }

            while (left < right && arr[++left] <= pivot)
                ;

            if (left < right) {
                arr[right] = arr[left];
            }
        }

        arr[right] = pivot;
        return right;
    }
}