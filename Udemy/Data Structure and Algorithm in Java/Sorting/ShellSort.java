package Sorting;

public class ShellSort {
    public static void main(String[] args) {
        int[] intArray = {20, 321, 12, 123, -2, -4, -12};

        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];

                int j = i;

                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }

                intArray[j] = newElement;
            }
        }

        for (int i: intArray) {
            System.out.println(i);
        }
    }
}
