public class SequentialSearch {
    public int search(int[] a, int num) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == num) return i;
        }

        return -1;
    }
}

// The sequential search runs in O(n) time. This means that, on average, the running time is
//proportional to the number of elements in the array. So if everything else is the same, then applying
//the sequential search to an array twice as long will take about twice as long, on average. The
//following argument is a proof of that fact.
//If x is in the sequence, say at x = si with i < n, then the loop will iterate i times. In that case, the
//running time is proportional to i, which is O(n) since i < n. If x is not in the sequence, then the
//loop will iterate n times, making the running time proportional to n, which is O(n).