public class BinarySearch {
    public int binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (x > a[mid]) {
                low = mid + 1;
            } else if (x < a[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}