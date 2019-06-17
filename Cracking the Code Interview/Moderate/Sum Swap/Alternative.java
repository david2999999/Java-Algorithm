package Moderate.SumSwap;

public class Alternative {

    private int[] findSwapValues(int[] array1, int[] array2) {
        Integer target = getTarget(array1, array2);
        if (target == null) return null;

        return findDifference(array1, array2, target);
    }

    private int[] findDifference(int[] array1, int[] array2, int target) {
        int a = 0;
        int b = 0;

        while (a < array1.length && b < array2.length) {
            int difference = array1[a] - array2[b];

            if (difference == target) {
                int[] values = {array1[a], array2[b]};
                return values;
            } else if (difference < target) {
                a++;
            } else {
                b++;
            }
        }

        return null;
    }


    private int sum(int[] arr) {
        int sum = 0;
        for (int n: arr) {
            sum += n;
        }

        return sum;
    }


    private Integer getTarget(int[] array1, int[] array2) {
        int sum1 = sum(array1);
        int sum2 = sum(array2);

        if ((sum1 - sum2) % 2 != 0) return null;

        return (sum1 - sum2) / 2;
    }
}
