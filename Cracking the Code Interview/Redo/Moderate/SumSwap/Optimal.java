package Redo.Moderate.SumSwap;

import java.util.HashSet;

public class Optimal {
    private int[] getSwapValues(int[] a, int[] b) {
        Integer targetSum = getTargetSum(a, b);

        if (targetSum == null) return null;

        return getTargetValues(a, b, targetSum);
    }

    private int[] getTargetValues(int[] a, int[] b, Integer targetSum) {
        HashSet<Integer> valuesInB = generateSet(b);

        for (int num: a) {
            int target = num - targetSum;

            if (valuesInB.contains(target)) {
                int[] values = {num, target};
                return values;
            }
        }

        return null;
    }

    private HashSet<Integer> generateSet(int[] arr) {
        if (arr.length == 0) return null;

        HashSet<Integer> set = new HashSet<>();

        for (int num: arr) {
            set.add(arr[num]);
        }

        return set;
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
