package SortingAndSearching;

public class PeaksAndValleysEfficient {
    private void sortByValleyPeak(int[] array) {
        for (int i = 0; i < array.length; i+= 2) {
            int biggestIndex = maxIndex(array, i - 1, i, i + 1);
            if (biggestIndex != i) {
                swap(array, i, biggestIndex);
            }
        }
    }

    private int maxIndex(int[] array, int a, int b, int c) {
        int len = array.length;

        int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? array[a] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < len ? array[a] : Integer.MIN_VALUE;

        int max = Math.max(a, Math.max(b, c));
        if (max == aValue) return a;
        else if (max == bValue) return b;
        else return c;
    }


    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
