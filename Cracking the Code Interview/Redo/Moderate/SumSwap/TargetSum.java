package Redo.Moderate.SumSwap;

public class TargetSum {
    private int[] findSwapValues(int[] a, int[] b) {
        Integer targetSum = getTargetSum(a, b);

        if (targetSum == null) return null;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if ((i - j) == targetSum) {
                    int[] value = {i, j};
                    return value;
                }
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
