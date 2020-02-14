package Sorting;

public class MergeSortDesc {
    public static void main(String[] args) {
        int[] intArray = {123, 412, 4125, 215, 1231, 1251251, 1251, 123123, 12312, 1212, 624};

        mergeSort(intArray, 0, intArray.length);

        for (int num: intArray) {
            System.out.println(num);
        }
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (end - start < 2) return;

        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        mergeDesc(array, start, mid, end);
    }

    private static void mergeDesc(int[] array, int start, int mid, int end) {
        if (array[mid - 1] >= array[mid]) return;

        int i = start;
        int j = mid;

        int[] temp = new int[end - start];
        int tempIndex = 0;

        while (i < mid && j < end) {
            temp[tempIndex++] = array[i] <= array[j] ? array[j++] : array[i++];
        }

        while (i != mid) {
            temp[tempIndex++] = array[i++];
        }

        while (j != end) {
            temp[tempIndex++] = array[j++];
        }

        System.arraycopy(temp, 0, array, start, tempIndex);
    }
}
