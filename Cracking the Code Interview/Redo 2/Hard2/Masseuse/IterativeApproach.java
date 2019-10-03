package Hard2.Masseuse;

// a popular Masseuse receives a sequence of back to back appointment requests and is debating which ones to accept.
// she needs a break between every appointment, and therefore can not accept any adjacent requests
// given a sequence of back to back appointments, find the longest total booked time for the Masseuse
public class IterativeApproach {
    // in this iterative approach, we will start with the end of the array
    // find the longest or most optimal time at that specific index
    public int maxMinutes(int[] massages) {
        // allocating 2 extra slot to prevent index out of bound checking
        int[] memo = new int[massages.length + 2];

        // used initially to use as 1 or 2 index away
        memo[massages.length] = 0;          // 1 index away
        memo[massages.length + 1] = 0;      // 2 index away

        for (int i = massages.length - 1; i >= 0; i--) {
            // add the current index + next next index (can not book adjacent indexes)
            int bestWith = massages[i] + memo[i + 2];

            // does not book the current index, but book the next index
            int bestWithout = memo[i + 1];

            // keeps track of the best/longest time at this specific index
            memo[i] = Math.max(bestWith, bestWithout);
        }

        return memo[0]; // the most optimal time
    }

    // we can save some space in the solution by not creating the array
    public int maxMinutesOptimized(int[] massages) {
        int oneAway = 0;    // 1 index away
        int twoAway = 0;    // 2 index away

        for (int i = massages.length - 1; i >= 0; i--) {
            // add the current index + next next index (can not book adjacent indexes)
            int bestWith = massages[i] + twoAway;

            // does not book the current index, but book the next index
            int bestWithout = oneAway;

            // the best/longest time at this specific index
            int current = Math.max(bestWith, bestWithout);

            // as i continues to subtract, our indexes needs to be decrementing too
            twoAway = oneAway;
            oneAway = current;
        }

        // return the most optimal time
        // note: oneAway has become current at the end
        return oneAway;
    }
}


































