public class BinarySearchRecursive {
    public int binarySearch(int[] arr, int x) {
        return binarySearch(arr, x, 0, x.length - 1);
    }

    private int binarySearch(int[] arr, int x, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (a[mid] < x) {
            return binarySearch(arr, x, mid + 1, high);
        } else if (a[mid] > x) {
            return binarySearch(arr, x, low, mid - 1);
        } else {
            return mid;
        }
    }
}