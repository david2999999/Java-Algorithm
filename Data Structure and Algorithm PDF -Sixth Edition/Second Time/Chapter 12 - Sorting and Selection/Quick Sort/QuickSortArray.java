public class QuickSortArray {
    public <K> void sort(K[] arr) {
        sort(arr, new Comparator<K>(), 0, arr.length - 1);
    }

    public <K> void sort(K[] arr, Comparator<K> comp, int low, int high) {
        if (low >= high) return;
        int left = low;
        int right = high - 1;

        K pivot = arr[high];
        while (left <= right) {
            while (left <= right && (comp(arr[left], pivot) < 0)) {
                left++;
            }

            while (left <= right && (comp(arr[right], pivot) > 0)) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        swap(arr, left, arr[high]);

        sort(arr, comp, low, left - 1);
        sort(arr, comp, left + 1, high);
    }

    private <K> void swap(K[] arr, int index1, int index2) {
        K temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}