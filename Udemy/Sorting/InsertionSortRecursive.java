package Sorting;

public class InsertionSortRecursive {
    public static void main(String[] args) {
        int[] intArray = {20, 321, 12, 123, -2, -4, -12};

        insertionSort(intArray, intArray.length);

        for (int i: intArray) {
            System.out.println(i);
        }
    }

    public static void insertionSort(int[] input, int numItems) {
        if (numItems < 2) return;

        insertionSort(input, numItems - 1);

        int newElement = input[numItems - 1];

        int i;
        for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }

        input[i] = newElement;

    }
}
