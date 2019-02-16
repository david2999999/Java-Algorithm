package Hard.Masseuse;

public class Solution4 {
    private int maxMinutes(int[] massages) {
        int oneAway = 0;
        int twoAway = 0;
        for (int i = massages.length - 1; i >= 0; i--) {
            int bestWith = massages[i] + twoAway;
            int bestWithout = oneAway;
            int current = Math.max(bestWith, bestWithout);
            twoAway = oneAway;
            oneAway = current;
        }

        return oneAway;
    }
}
