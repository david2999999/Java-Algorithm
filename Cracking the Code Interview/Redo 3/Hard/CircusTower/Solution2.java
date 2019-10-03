package Hard.CircusTower;

import java.util.ArrayList;
import java.util.Collections;

public class Solution2 {
    private ArrayList<HtWt> longestIncreasingSeq(ArrayList<HtWt> array) {
        Collections.sort(array);

        ArrayList<ArrayList<HtWt>> solutions = new ArrayList<>();
        ArrayList<HtWt> bestSequence = null;

        for (int i = 0; i < array.size(); i++) {
            ArrayList<HtWt> longestAtIndex = bestSequenceAtIndex(array, solutions, i);
            solutions.add(i, longestAtIndex);
            bestSequence = max(bestSequence, longestAtIndex);
        }

        return bestSequence;
    }

    private ArrayList<HtWt> bestSequenceAtIndex(ArrayList<HtWt> array, ArrayList<ArrayList<HtWt>> solutions, int index) {
        HtWt value = array.get(index);

        ArrayList<HtWt> bestSequence = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            ArrayList<HtWt> solution = solutions.get(index);
            if (canAppend(solution, value)) {
                bestSequence = max(solution, bestSequence);
            }
        }

        ArrayList<HtWt> best = (ArrayList<HtWt>) bestSequence.clone();
        best.add(value);
        return best;
    }

    private ArrayList<HtWt> max(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
        if (seq1 == null) {
            return seq2;
        } else if (seq2 == null) {
            return seq1;
        }

        return seq1.size() > seq2.size() ? seq1 : seq2;
    }

    private boolean canAppend(ArrayList<HtWt> solution, HtWt value) {
        if (solution == null) return false;
        if (solution.size() == 0) return true;

        HtWt last = solution.get(solution.size() - 1);
        return last.isBefore(value);
    }
}
