package Redo.SortingAndSearching;

public class RotatedArray {
    private int search(int[] a, int left, int right, int x) {
        if (right < left) return -1;

        int mid = (left + right) / 2;

        if (a[mid] == x) {
            return mid;
        }

        if (a[left] < a[mid]) { // left is sorted properly
            if (x >= a[left] && x < a[mid]) {
                return search(a, left, mid - 1, x);
            } else {
                return search(a, mid + 1, right, x);
            }
        } else if (a[left] > a[mid]) { // right is sorted properly
            if (x > a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x);
            } else {
                return search(a, left, mid - 1, x);
            }
        } else if (a[left] == a[mid]) {
            if (a[right] != a[mid]) {
                search(a, mid + 1, right, x);
            } else {
                int result = search(a, left, mid - 1, x);

                if (result == -1) {
                    return search(a, mid + 1, right, x);
                } else {
                    return result;
                }
            }
        }

        return -1;
    }
}
