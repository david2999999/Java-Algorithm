public class SearchInSortedRotatedArray {
    public int search(int[] a, int target) {
        return search(a, 0, a.length - 1, target);
    }

    private int search(int[] a, int left, int right, int target) {
        int mid = (left + right) / 2;

        if (a[mid] == target) {
            return mid;
        }

        if (right < left) {
            return -1;
        }

        if (a[left] < a[mid]) {
            if (target >= a[left] && target < a[mid]) {
                return search(a, left, mid - 1, target);
            } else {
                return search(a, mid + 1, right, target);
            }
        } else if (a[left] > a[mid]) {
            if (target > a[mid] && target <= a[right]) {
                return search(a, mid + 1, right, target);
            } else {
                return search(a, left, mid - 1, target);
            }
        } else {
            if (a[mid] != a[right]) {
                return search(a, mid + 1, right, target);
            } else {
                int result = search(a, left, mid - 1, target);

                if (result == -1) {
                    return search(a, mid + 1, right, target);
                } else {
                    return result;
                }
            }
        }
    }
}