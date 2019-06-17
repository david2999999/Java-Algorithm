package Moderate.SumSwap;

import java.util.HashSet;

public class Optimized {
    private int[] findSwapValues(int[] array1, int[] array2) {
        Integer target = getTarget(array1, array2);

        if (target == null) return null;
        return findDifference(array1, array2, target);
    }

    private int[] findDifference(int[] array1, int[] array2, int target) {
        HashSet<Integer> contents2 = getContent(array2);

        for (int one: array1) {
            int two = one - target;
            if (contents2.contains(two)) {
                int[] values = {one, two};
                return values;
            }
        }

        return null;
    }

    private HashSet<Integer> getContent(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int n: arr) {
            set.add(n);
        }

        return set;
    }



    private Integer getTarget(int[] array1, int[] array2) {
        int sum1 = sum(array1);
        int sum2 = sum(array2);

        if ((sum1 - sum2) % 2 != 0) return null;

        return (sum1 - sum2) / 2;
    }



    private int sum(int[] arr) {
        int sum = 0;
        for (int n: arr) {
            sum += n;
        }

        return sum;
    }
}
