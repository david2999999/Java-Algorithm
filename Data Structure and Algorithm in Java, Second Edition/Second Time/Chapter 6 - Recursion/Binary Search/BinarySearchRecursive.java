public class BinarySearchRecursive {
    public int search(int[] arr, int key) {
        return search(arr, key, 0, arr.length - 1);
    }

    private int search(int[] arr, int key, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            return search(arr, key, mid + 1, high);
        } else {
            return search(arr, key, low, mid - 1);
        }
    }
}