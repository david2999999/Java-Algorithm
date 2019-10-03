package Hard.ShortestSuperSequence;

public class Solution3 {
    private Range shortestSuperSequence(int[] big, int[] small) {
        int[] closures = getClosures(big, small);
        return getShortestClosure(closures);
    }

    private Range getShortestClosure(int[] closures) {
        Range shortest = new Range(0, closures[0]);

        for (int i = 1; i < closures.length; i++) {
            if (closures[i] == -1) break;

            Range range = new Range(i, closures[i]);
            if (!shortest.shorterThan(range)) {
                shortest = range;
            }
        }

        return shortest;
    }

    private int[] getClosures(int[] big, int[] small) {
        int[] closure = new int[big.length];

        for (int i = 0; i < small.length; i++) {
            sweepForClosures(big, closure, small[i]);
        }

        return closure;
    }

    private void sweepForClosures(int[] big, int[] closure, int value) {
        int next = -1;
        for (int i = big.length - 1; i >= 0; i--) {
            if (big[i] == value) {
                next = i;
            }

            if ((next == -1 || closure[i] < next) && (closure[i] != -1)) {
                closure[i] = next;
            }
        }
    }
}
