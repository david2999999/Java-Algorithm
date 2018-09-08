package Moderate;

public class MinDifferenceFrom2Array {
    private int findSmallestDifference(int[] array1, int[] array2) {
        if (array1.length == 0 || array2.length == 0) return -1;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (Math.abs(array1[i] - array2[j]) < min) {
                    min = Math.abs(array1[i] - array2[j]);
                }
            }
        }

        return min;
    }
}
