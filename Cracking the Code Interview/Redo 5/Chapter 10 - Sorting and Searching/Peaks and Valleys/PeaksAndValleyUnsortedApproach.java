public class PeaksAndValleyUnsortedApproach {
    public void sortValleyPeak(int[] array) {
        if (array.length < 2) {
            return;
        }

        for (int i = 1; i < array.length; i += 2) {
            int biggestIndex = maxIndex(array, i - 1, i, i + 1);

            if (biggestIndex != i) {
                swap(array, i, biggestIndex);
            }
        }
    }

    private int maxIndex(int[] array, int a, int b, int c) {
        int length = array.length;

        int aValue = a >= 0 && a < length ? array[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < length ? array[b] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < length ? array[c] : Integer.MIN_VALUE;

        int max = Math.max(aValue, Math.max(bValue, cValue));

        if (aValue == max) {
            return a;
        } else if (bValue == max) {
            return b;
        } else {
            return c;
        }
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}