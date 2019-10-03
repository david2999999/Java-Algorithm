package Hard2.Masseuse;

// a popular Masseuse receives a sequence of back to back appointment requests and is debating which ones to accept.
// she needs a break between every appointment, and therefore can not accept any adjacent requests
// given a sequence of back to back appointments, find the longest total booked time for the Masseuse
public class RecursiveApproach {
    // this solution will use the recursive approach
    // we will either add the current appointment and add the next next appointment (can't accept adjacent)
    // or we will skip the current appointment, and add the next appointment instead
    public int maxMinutes(int[] massages) {
        return maxMinutes(massages, 0);
    }

    private int maxMinutes(int[] massages, int index) {
        if (index >= massages.length) { // index out of bound
            return 0;
        }

        // add the current appointment and add the next next appointment (can't accept adjacent)
        int bestWith = massages[index] + maxMinutes(massages, index + 2);

        // we will skip the current appointment, and add the next appointment instead
        int bestWithout = maxMinutes(massages, index + 1);

        // return the longest time best with the current appointment, or best without the current appointment
        return Math.max(bestWith, bestWithout);
    }

    // an optimization is to use memoization to avoid duplicate recursive calls
    // solution 2: optimal
    public int maxMinutesMemo(int[] massages) {
        int[] memo = new int[massages.length];  // used to keep track of previous recursive calls
        return maxMinutesMemo(massages, 0, memo);
    }

    private int maxMinutesMemo(int[] massages, int index, int[] memo) {
        if (index >= massages.length) { // index out of bound
            return 0;
        }

        if (memo[index] == 0) { // if we have not made this recursive call
            // add the current appointment and add the next next appointment (can't accept adjacent)
            int bestWith = massages[index] + maxMinutesMemo(massages, index + 2, memo);

            // we will skip the current appointment, and add the next appointment instead
            int bestWithout = maxMinutesMemo(massages, index + 1, memo);

            // keeps track of the maximum time length at the specific index
            memo[index] = Math.max(bestWith, bestWithout);
        }

        // return the maximum/longest time at this index
        return memo[index];
    }
}






















