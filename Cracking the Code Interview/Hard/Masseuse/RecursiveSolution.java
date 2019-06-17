package Hard.Masseuse;

public class RecursiveSolution {
    public int maxMinutes(int[] messages) {
        return maxMinutes(messages, 0);
    }


    private int maxMinutes(int[] messages, int index) {
        if (index >= messages.length) {
            return 0;
        }

        int bestWith = messages[index] + maxMinutes(messages, index + 2);
        int bestWithout = maxMinutes(messages, index + 1);

        return Math.max(bestWith, bestWithout);
    }
}
