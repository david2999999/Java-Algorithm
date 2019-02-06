package Moderate.SumSwap;

public class Solution2 {
    public int[] findSwapValues(int[] array1, int[] array2) {
        Integer target = getTarget(array1, array2);
        if (target == null) return null;

        for (int one : array1) {
            for (int two : array2) {
                if (one - two == target) {
                    int[] values = {one, two};
                    return values;
                }
            }
        }

        return null;
    }

    private Integer getTarget(int[] array1, int[] array2) {
        int sum1 = sum(array1);
        int sum2 = sum(array2);

        if ((sum1 - sum2) % 2 != 0) {
            return null;
        }

        return (sum1 - sum2) / 2;
    }

    private int sum(int[] array) {
        int sum = 0;

        for (int num: array) {
            sum += num;
        }

        return sum;
    }
}
