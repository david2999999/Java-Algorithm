package Hard.Masseuse;

public class Solution3 {
    private int maxMinutes(int[] massages) {
        int[] memo = new int[massages.length + 2];
        memo[massages.length] = 0;
        memo[massages.length + 1] = 0;

        for (int i = massages.length - 1; i >= 0; i--) {
            int bestWith = massages[i] + massages[i + 2];
            int bestWithout = massages[i + 1];
            memo[i] = Math.max(bestWith, bestWithout);
        }

        return memo[0];
    }
}
