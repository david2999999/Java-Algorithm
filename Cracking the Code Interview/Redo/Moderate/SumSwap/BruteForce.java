package Redo.Moderate.SumSwap;

public class BruteForce {
    private int[] getSwapNumbers(int[] a, int[] b) {
        int sumA = sum(a);
        int sumB = sum(b);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int newSum1 = sumA - i + j;
                int newSum2 = sumB + i - j;

                if (newSum1 == newSum2) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }

        return null;
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
