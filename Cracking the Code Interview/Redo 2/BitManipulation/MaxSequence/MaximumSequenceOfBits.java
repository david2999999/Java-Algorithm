package BitManipulation.MaxSequence;

import java.util.ArrayList;

// Given an integer and you can flip exactly one bit from 0 to a 1
// write a function to find the length of the longest sequence of 1s you can create
public class MaximumSequenceOfBits {
    // this is the brute force approach
    // walk through the integer and keep track of the number of 1s and 0s and store them inside an array
    // even indexes will count the number of zeros, while odd indexes will count number of 1s
    // then we walk through the array to check if any sequences can be merged
    public int longestSequence(int n) {
        if (n == -1) {
            return Integer.BYTES * 8;   // return a 64 bit error message
        }

        // count the number of alternating 1s and 0s
        ArrayList<Integer> sequences = getAlternatingSequences(n);
        return findLongestSequence(sequences);  // find the longest sequence
    }

    private int findLongestSequence(ArrayList<Integer> seq) {
        int maxSeq = 1; // set the current max sequence to 1

        // don't forget
        // the count of 0s are stored at even indexes
        // the count of 1s are stored at odd indexes
        for (int i = 0; i < seq.size(); i += 2) {
            int zerosSeq = seq.get(i);  // get the number of 0s in even index
            int onesSeqRight = i - 1 >= 0 ? seq.get(i - 1) : 0; // get the number of 1s on the right
            int onesSeqLeft = i + 1 < seq.size() ? seq.get(i + 1) : 0;  // get the number of 1s on the left

            int thisSeq = 0;    // current seq set to 0
            if (zerosSeq == 1) {    // if there is one zero, we can flip this zero to merge left and right
                thisSeq = onesSeqLeft + 1 + onesSeqRight;   // merge the 1s with the flip 0 bit
            }

            if (zerosSeq > 1) { // adding the flip bit to the longer side of the 2
                thisSeq = 1 + Math.max(onesSeqLeft, onesSeqRight);
            } else if (zerosSeq == 0) { // no zero, take the longer side
                thisSeq = Math.max(onesSeqLeft, onesSeqRight);
            }

            maxSeq = Math.max(thisSeq, maxSeq); // update the maximum sequence
                                                // by comparing with the current sequence
        }

        return maxSeq;  // the maximum number of 1s
    }

    private ArrayList<Integer> getAlternatingSequences(int n) {
        ArrayList<Integer> sequences = new ArrayList<>();

        int searchingFor = 0;   // currently searching for 0
        int counter = 0;    // current counter for the number we are searching for

        for (int i = 0; i < Integer.BYTES * 8; i++) {
            if ((n & 1) != searchingFor) {  // if the current number is not what we are searching for
                sequences.add(counter); // add the accumulated counter
                searchingFor = n & 1;   // flip 1 to 0 or 0 to 1
                counter = 0;    // reset the counter
            }

            counter++;  // increment the counter
            n >>>= 1;   // shift n to the right by 1
        }

        sequences.add(counter); // add the last counter

        return sequences;   // return the list of counts of 1s and 0s
    }
}

















