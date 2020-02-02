public class BinarySearchIterative {
    public static boolean search(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (data[mid] == target) {
                return true;
            } else if (data[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}