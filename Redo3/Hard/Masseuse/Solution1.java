package Hard.Masseuse;

public class Solution1 {
    private int maxMinutes(int[] massages) {
        return maxMinutes(massages, 0);
    }

    private int maxMinutes(int[] massages, int index) {
        if (index >= massages.length) return 0;

        int bestWith = massages[index] + maxMinutes(massages, index + 2);
        int bestWithout = maxMinutes(massages, index + 1);

        return Math.max(bestWith, bestWithout);
    }
}
