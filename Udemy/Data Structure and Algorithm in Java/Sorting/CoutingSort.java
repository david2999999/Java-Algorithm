package Sorting;

public class CoutingSort {
    public static void main(String[] args) {
        int[] intArray = {2, 4, 1, 4, 2, 4, 1, 8, 10, 2, 3, 4, 5, 6};

        countingSort(intArray, 1, 10);

        for (int i: intArray) {
            System.out.println(i);
        }
    }

    public static void countingSort(int[] input, int min, int max) {
        int[] countArray = new int[(max - min) + 1];

        for (int num: input) {
            countArray[num - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}
