package Redo.Moderate.SumSwap;

public class SortedSumSwap {
    private int[] findSumSwap(int[] array1, int[] array2) {
        Integer targetSum = getTargetSum(array1, array2);

        if (targetSum == null) return null;

        return getTargetValues(array1, array2, targetSum);
    }

    private int[] getTargetValues(int[] array1, int[] array2, Integer targetSum) {
        int a = 0;
        int b = 0;

        while (a < array1.length && b < array2.length) {
            int value = array1[a] - array2[b];

            if (value == targetSum) {
                int[] values = {array1[a], array2[b]};
                return values;
            } else if (value < targetSum) {
                a++;
            } else {
                b++;
            }
        }

        return null;
    }

    private Integer getTargetSum(int[] a, int[] b) {
        int sumA = sum(a);
        int sumB = sum(b);

        if ((sumA - sumB) % 2 != 0) return null;
        return (sumA - sumB) / 2;
    }

    private int sum(int[] a) {
        if (a.length == 0) return 0;

        int sum = 0;

        for (int num: a) {
            sum += num;
        }

        return sum;
    }
}
