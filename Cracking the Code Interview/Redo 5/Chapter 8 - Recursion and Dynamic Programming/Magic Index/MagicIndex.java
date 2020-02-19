public class MagicIndex {
    public int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    private int magicFast(int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] < mid) {
            return magicFast(array, mid + 1, end);
        } else {
            return magicFast(array, start, mid - 1);
        }
    }
}