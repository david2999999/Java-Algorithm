public class BinarySearch {
    public int search(int[] a, int x) {
        return search(a, x, 0, a.length - 1);
    }

    private int search(int[] a, int x, int low, int high) {
        if (low > high) return -1;

        int mid = (low + high) / 2;

        if (a[mid] == x) {
            return mid;
        } else if (a[mid] < x) {
            return search(a, x, mid + 1, high);
        } else {
            return search(a, x, low, mid - 1);
        }
    }
}