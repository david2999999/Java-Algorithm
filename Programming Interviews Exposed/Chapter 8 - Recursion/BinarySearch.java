public class BinarySearch {
    public int search(int[] array, int target) {
        return binarySearchRecursively(array, target, 0, array.length - 1);
    }

    private int binarySearchRecursively(int[] array, int target, int lower, int upper) {
        if (lower > upper) return -1;

        int mid = (upper - lower) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return binarySearchRecursively(array, target, mid + 1, upper);
        } else {
            return binarySearchRecursively(array, target, lower, mid - 1);
        }
    }
}
