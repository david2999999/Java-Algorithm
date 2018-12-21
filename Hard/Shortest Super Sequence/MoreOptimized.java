package Hard.ShortestSuperSequence;

public class MoreOptimized {

    public Range shortestSupersequence(int[] big, int[] small) {
        int[] closures = getClosures(big, small);
        return getShortestRange(closures);
    }

    private int[] getClosures(int[] big, int[] small) {
        int[] closure = new int[big.length];
        for (int i = 0; i < small.length; i++) {
            sweepForClosure(big, closure, small[i]);
        }

        return closure;
    }

    private void sweepForClosure(int[] big, int[] closures, int value) {
        int next = -1;
        for (int i = big.length - 1; i >= 0; i--) {
            if (big[i] == value) {
                next = i;
            }

            if ((next == -1 || closures[i] < next) && (closures[i] != -1))
                closures[i] = next;
        }
    }

    private Range getShortestRange(int[] closures) {
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
}
