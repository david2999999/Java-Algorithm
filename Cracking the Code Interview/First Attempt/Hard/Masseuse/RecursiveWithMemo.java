package Hard.Masseuse;

public class RecursiveWithMemo {
    public int maxMinutes(int[] massages) {
        int[] memo = new int[massages.length];
        return maxMinutes(massages, 0, memo);
    }

    private int maxMinutes(int[] massages, int index, int[] memo) {
        if (index >= massages.length) {
            return 0;
        }

        if (memo[index] == 0) {
            int bestWith = massages[index] + maxMinutes(massages, index + 2, memo);
            int bestWithout = maxMinutes(massages, index + 1, memo);
            memo[index] = Math.max(bestWith, bestWithout);
        }

        return memo[index];
    }
}
