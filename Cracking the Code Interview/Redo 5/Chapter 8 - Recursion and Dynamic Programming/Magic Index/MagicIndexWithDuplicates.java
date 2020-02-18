public class MagicIndexWithDuplicates {
    public int findMagicIndex(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        return findMagicIndex(array, 0, array.length - 1);
    }

    private int findMagicIndex(int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];

        if (midValue == midIndex) {
            return midIndex;
        }

        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = findMagicIndex(array, start, leftIndex);
        if (left >= 0) {
            return left;
        }

        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = findMagicIndex(array, rightIndex, end);

        return right;
    }
}