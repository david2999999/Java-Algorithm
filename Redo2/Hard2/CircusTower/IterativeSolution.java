package Hard2.CircusTower;

import java.util.ArrayList;
import java.util.Collections;

// A circus is designing a tower routine consisting of people standing atop one another's shoulder.
// For practical reason, each person must be shorter and lighter than the person below him or her.
// Given the height and weights of each person in the circus,
// write a method to compute the largest number of people in such a tower
public class IterativeSolution {
    // to find the longest sequence, we just need to append the current person
    // to the longest previous list
    public ArrayList<HtWt> longestIncreasingSeq(ArrayList<HtWt> array) {
        Collections.sort(array);    // sort the array

        // contains all of the previous sequences
        ArrayList<ArrayList<HtWt>> solutions = new ArrayList<>();
        ArrayList<HtWt> bestSequence = null;    // the longest sequence

        for (int i = 0; i < array.size(); i++) {
            // find the longest list that the current element can be appended to
            ArrayList<HtWt> longestAtIndex = bestSeqAtIndex(array, solutions, i);
            solutions.add(i, longestAtIndex);   // add the list to the previous lists
            bestSequence = max(bestSequence, longestAtIndex);   // update the longest sequence
        }

        return bestSequence;    // longest sequence
    }

    private ArrayList<HtWt> bestSeqAtIndex(ArrayList<HtWt> array,
                                                ArrayList<ArrayList<HtWt>> solutions, int index) {
        HtWt value = array.get(index);  // get the current value from the index

        ArrayList<HtWt> bestSequence = new ArrayList<>();   // the longest sequence

        for (int i = 0; i < index; i++) {
            ArrayList<HtWt> solution = solutions.get(i);    // get the previous lists

            if (canAppend(solution, value)) {   // if we can append the value to the solution
                bestSequence = max(solution, bestSequence); // get the longest previous sequence
            }
        }

        ArrayList<HtWt> best = (ArrayList<HtWt>) bestSequence.clone();  // clone the previous longest sequence
        best.add(value);    // add the current value
        return best;
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














