package Sorting;

import java.util.Arrays;

public class JDKSort {
    public static void main(String[] args) {
        int[] intArray = {20, 321, 12, 123, -2, -4, -12};

        //Arrays.sort(intArray);
        Arrays.parallelSort(intArray);

        for (int i: intArray) {
            System.out.println(i);
        }

    }
}
