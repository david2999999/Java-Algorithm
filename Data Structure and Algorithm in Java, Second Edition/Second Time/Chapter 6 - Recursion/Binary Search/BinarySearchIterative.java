public class BinarySearchIterative {
    public int find(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low < high) {
            mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}