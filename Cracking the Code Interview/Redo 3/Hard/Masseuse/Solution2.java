package Hard.Masseuse;

public class Solution2 {
    private int maxMinutes(int[] massages) {
        int[] memo = new int[massages.length];
        return maxMinutes(massages, 0, memo);
    }

    private int maxMinutes(int[] massages, int index, int[] memo) {
        if (index >= massages.length) return 0;

        if (memo[index] == 0) {
            int bestWith = massages[index] + maxMinutes(massages, index + 2, memo);
            int bestWithOut = maxMinutes(massages, index + 1, memo);
            memo[index] = Math.max(bestWith, bestWithOut);
        }

        return memo[index];
    }
}
