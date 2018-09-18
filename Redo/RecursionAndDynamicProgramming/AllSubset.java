package Redo.RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class AllSubset {
    private ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allSubSets = new ArrayList<>();
        int max = 1 << set.size();

        for (int i = 0; i < max; i++) {
            ArrayList<Integer> subsets = generateAllSubsets(i, set);
            allSubSets.add(subsets);
        }

        return allSubSets;
    }

    private ArrayList<Integer> generateAllSubsets(int k, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;

        for (int i = k; i > 0; i >>= 1) {
            if ((i & 1) == 1) {
                subset.add(set.get(index));
            }

            index++;
        }

        return subset;

    }


}
