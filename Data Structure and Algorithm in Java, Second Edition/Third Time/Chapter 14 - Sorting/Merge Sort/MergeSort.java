public class MergeSort {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    public void sort(int[] arr, int low, int high) {
        if (high - low < 2) return;

        int mid = (low + high) / 2;
        sort(arr, low, mid);
        sort(arr, mid, high);
        merge(arr, low, mid, high);
    }

    private void merge(int[] arr, int low, int mid, int high) {
        if (arr[mid - 1] <= arr[mid]) return;

        int index = 0, left = low, right = mid;
        int[] temp = new int[high - low];

        while (left < mid && right < high) {
            temp[index++] = (temp[left] <= temp[right]) ? temp[left++] : temp[right++];
        }

        System.arraycopy(arr, left, arr, index + left, mid - left);
        System.arraycopy(temp, 0, arr, low, index);
    }
}