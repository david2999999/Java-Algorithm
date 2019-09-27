public class BinarySearch {
    public int search(int[] array, int target) {
        return binarySearchRecursively(array, target, 0, array.length - 1);
    }

    public int search2(int[] array, int target) {
        return binarySearchIteratively(array, target);
    }

    private int binarySearchRecursively(int[] array, int target, int lower, int upper) {
        if (lower > upper) return -1;

        int mid = (upper + lower) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return binarySearchRecursively(array, target, mid + 1, upper);
        } else {
            return binarySearchRecursively(array, target, lower, mid - 1);
        }
    }

    private int binarySearchIteratively(int[] array, int target) {
        int lower = 0, upper = array.length - 1;
        int mid;

        while(true) {
            if (lower > upper) return -1;

            mid = (upper + lower) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
    }
}