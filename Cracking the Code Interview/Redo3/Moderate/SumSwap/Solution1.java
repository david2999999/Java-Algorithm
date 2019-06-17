package Moderate.SumSwap;

public class Solution1 {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = sum(array1);
        int sum2 = sum(array2);

        for (int one : array1) {
            for (int two : array2) {
                int newSum1 = sum1 - one + two;
                int newSum2 = sum2 - two + one;

                if (newSum1 == newSum2) {
                    int[] values = {one, two};
                    return values;
                }
            }
        }

        return null;
    }

    private int sum(int[] array) {
        int sum = 0;

        for (int num: array) {
            sum += num;
        }

        return sum;
    }
}
