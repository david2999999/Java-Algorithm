public class BinarySearchRecursive {
    public int binarySearch(int[] arr, int x) {
        return binarySearchRecursive(arr, x, 0, arr.length - 1);
    }

    public int binarySearchRecursive(int[] a, int x, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (a[mid] < x) {
            return binarySearchRecursive(a, x, mid + 1, high);
        } else if (a[mid] > x) {
            return binarySearchRecursive(a, x, low, mid - 1);
        } else {
            return mid;
        }
    }
}