package RecursionAndDynamicProgramming.PowerSet;

import java.util.ArrayList;

public class Iterative {
    public ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        int max = 1 << set.size();

        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k ,set);
            allSubsets.add(subset);
        }

        return allSubsets;
    }

    private ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;

        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(set.get(index));
            }

            index++;
        }

        return subset;
    }
}
