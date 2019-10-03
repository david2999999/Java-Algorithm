package Hard.CircusTower;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class CircusTowerRecursive {
    public ArrayList<HtWt> longestIncreasingSequence(ArrayList<HtWt> items) {
        Collections.sort(items);
        return bestSeqAtIndex(items, new ArrayList<>(), 0);
    }

    private ArrayList<HtWt> bestSeqAtIndex(ArrayList<HtWt> array, ArrayList<HtWt> sequence, int index) {
        if (index >= array.size()) return sequence;

        HtWt value = array.get(index);

        ArrayList<HtWt> bestWith = null;
        if (canAppend(sequence, value)) {
            ArrayList<HtWt> sequenceWith = (ArrayList<HtWt>)sequence.clone();
            sequenceWith.add(value);
            bestWith = bestSeqAtIndex(array, sequenceWith, index + 1);
        }

        ArrayList<HtWt> bestWithout = bestSeqAtIndex(array, sequence, index + 1);
        return max(bestWith, bestWithout);
    }

    private boolean canAppend(ArrayList<HtWt> solution, HtWt value) {
        if (solution == null) return false;
        if (solution.size() == 0) return true;

        HtWt last = solution.get(solution.size() - 1);
        return last.isBefore(value);
    }

    private ArrayList<HtWt> max(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
        if (seq1 == null)
            return seq2;
        else if (seq2 == null)
            return seq1;

        return seq1.size() > seq2.size() ? seq1 : seq2;
    }
}
