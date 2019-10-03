package RecursionAndDynamicProgramming.PowerSet;

import java.util.ArrayList;

public class Recursion {
    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;

        if (set.size() == index) {
            allsubsets = new ArrayList<>();
            allsubsets.add(new ArrayList<>());
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubset = new ArrayList<>();

            for (ArrayList<Integer> subset: allsubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubset.add(newSubset);
            }

            allsubsets.addAll(moreSubset);
        }

        return allsubsets;
    }
}
