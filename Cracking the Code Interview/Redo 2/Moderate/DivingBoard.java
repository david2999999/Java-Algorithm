package Moderate;

import java.util.HashSet;

// you are building a diving board by placing a bunch of planks of wood end-to-end
// there are exactly two types of planks, one of length shorter and one of length longer
// you must use exactly k planks of wood. write all method to generate all possible length
public class DivingBoard {
    public HashSet<Integer> allLengths(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();  // a set to contain all possible lengths
        getAllLengths(k, 0, shorter, longer, lengths);
        return lengths; // return all possible lengths
    }

    // k is the total number of planks we can use
    // total is current total length in this recursive function
    // shorter is the shorter length plank
    // longer is the longer length plank
    private void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths) {
        if (k == 0) {   // we have used all all of the planks
            lengths.add(total); // add the total length to the set
            return;
        }

        // subtract one plank since we used it on this recursive call
        // add a shorter length plank to the running total
        getAllLengths(k - 1, total + shorter, shorter, longer, lengths);

        // subtract one plank since we used it on this recursive call
        // add a longer length plank to the running total
        getAllLengths(k - 1, total + longer, shorter, longer, lengths);
    }


    // we can optimized the solution using memoization, by saving recursive paths that we have already
    // went through. Then we do not have duplicate recursive paths
    public HashSet<Integer> allLengthsOptimized(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>(); // all possible lengths
        HashSet<String> visited = new HashSet<>();  // the path that we have already visited
        getAllLengthsOptimized(k, 0, shorter, longer, lengths, visited);
        return lengths; // return all possible lengths
    }

    private void getAllLengthsOptimized(int k, int total, int shorter, int longer, HashSet<Integer> lengths,
                                                            HashSet<String> visited) {
        if (k == 0) {   // no more planks left
            lengths.add(total);
            return;
        }

        // the key for the visited set will be
        // the number of planks left and the running total length
        String key = k + " " + total;

        if (visited.contains(key)) {    // if we already went down this recursive call
            return;
        }

        getAllLengthsOptimized(k - 1, total + shorter, shorter, longer, lengths, visited);
        getAllLengthsOptimized(k - 1, total + longer, shorter, longer, lengths, visited);
        visited.add(key);   // record that we already went down this recursive call
    }


    // the most optimal solution
    // this solution is just finding the different number of shorter and longer planks
    // by using that we can only have a total of k planks
    // so if the number of shorter planks is s
    // then the number of longer planks has to be L = k - s
    public HashSet<Integer> allLenghts(int k, int shorter, int longer) {
        HashSet<Integer> lengths = new HashSet<>();

        // nShorter = number of shorter planks
        for (int nShorter = 0; nShorter <= k; nShorter++) {
            // since the total number of planks if k
            int nLonger = k - nShorter; // the total number of longer plank is k - number of shorter planks
            int length = nShorter * shorter + nLonger * longer;
            lengths.add(length);
        }

        return lengths;
    }

}

















