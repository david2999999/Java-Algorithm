public class BinarySearch {
    public boolean binarySearch(int[] data, int target) {
        return binarySearch(data, target, 0, data.length - 1);
    }

    private boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high) return false;

        int mid = (low + high) / 2;

        if (data[mid] == target) {
            return true;
        } else if (data[mid] < target) {
            return binarySearch(data, target, mid + 1, high);
        } else {
            return binarySearch(data, target, low, mid - 1);
        }
    }
}