package Hard2.CircusTower;

import java.util.ArrayList;
import java.util.Collections;

// A circus is designing a tower routine consisting of people standing atop one another's shoulder.
// For practical reason, each person must be shorter and lighter than the person below him or her.
// Given the height and weights of each person in the circus,
// write a method to compute the largest number of people in such a tower
public class RecursiveApproach {
    // we have to create a class to model the height and weight
    // the answer we are trying to find is a list that is going in increasing order
    // where the front of the list are the lighter people
    // where the end of the list are the heavier people

    public ArrayList<HtWt> longestIncreasingSeq(ArrayList<HtWt> items) {
        Collections.sort(items);    // sort the list, we want the result to be a increasing sequence
        return bestSeqAtIndex(items, new ArrayList<HtWt>(), 0);
    }

    // constructing the list at each index
    private ArrayList<HtWt> bestSeqAtIndex(ArrayList<HtWt> array, ArrayList<HtWt> sequence, int index) {
        // no more people left, return the sequence
        if (index >= array.size()) return sequence;

        HtWt value = array.get(index);  // the current person in the list

        ArrayList<HtWt> bestWith = null;    // the list with the current person added
        if (canAppend(sequence, value)) {   // check if we can add the person to the sequence
            ArrayList<HtWt> sequenceWith = (ArrayList<HtWt>) sequence.clone();  // clone the original sequence
            sequenceWith.add(value);    // add the current person to the sequence

            // finding the best sequence with the current person added to the sequence
            bestWith = bestSeqAtIndex(array, sequenceWith, index + 1);
        }

        // the sequence without the current person added
        ArrayList<HtWt> bestWithout = bestSeqAtIndex(array, sequence, index + 1);

        // checking which list is better,
        // the list with the current person added
        // or the list without the current person added
        return max(bestWith, bestWithout);
    }

    private ArrayList<HtWt> max(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
        if (seq1 == null) return seq2;  // if seq1 does not exist
        else if (seq2 == null) return seq1; // if seq2 does not exist

        return seq1.size() > seq2.size() ? seq1 : seq2; // return the longer list
    }

    private boolean canAppend(ArrayList<HtWt> solution, HtWt value) {
        if (solution == null) { // list does not exist, return false
            return false;
        }

        if (solution.size() == 0) { // there is no one in the list
            return true;    // the person can be added
        }

        HtWt last = solution.get(solution.size() - 1);  // get the last person in the list
        return last.isBefore(value);    // check if the person can be appended to the last person in the list
    }
}














