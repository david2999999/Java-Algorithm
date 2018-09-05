package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet {
    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.addAll(Arrays.asList(1,2,3,4,5));
        System.out.println(getSubsets(set, 0));
    }

    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;

        if (set.size() == index) {
            allsubsets = new ArrayList<>();
            allsubsets.add(new ArrayList<>()); // new subset
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            for (ArrayList<Integer> subset: allsubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }

            allsubsets.addAll(moreSubsets);
        }

        return allsubsets;
    }
}
