package RecursionAndDynamicProgramming.PowerSet;

import java.util.ArrayList;

// write a method to return all subsets of a set
public class PowerSet {
    // the first method will use recursion to generate each subset
    // the recursion example
    // set = {a1, a2, a3}, index = 0

    // {}                                                       index = 3   base case
    // {a3} {}                                                  index = 2   add a3 to the previous subsets
    // {a2 a3} {a2} {a3} {}                                     index = 1   add a2 to the previous subsets
    // {a1 a2 a3} {a1 a2} {a1 a3} {a1} {a2 a3} {a2} {a3} {}     index = 0   add a1 to the previous subsets

    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;   // list of all of the subsets

        if (set.size() == index) {  // base case, add an empty set
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());  // add empty set
        } else {
            allSubsets = getSubsets(set, index + 1);    // generate the subset for the next index first
            int item = set.get(index);  // get the current integer from the index

            // the list of subsets that are generated from the previous subsets
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();

            for (ArrayList<Integer> subset: allSubsets) {
                // new subset that includes previous subsets + current item
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);   // include previous subsets
                newSubset.add(item); // add current item
                moresubsets.add(newSubset);
            }

            allSubsets.addAll(moresubsets); // add to all of the subsets
        }

        return allSubsets;  // return all subsets
    }

    // alternative solution is using combinatorics
    // we can find all subsets using bits
    // since when generating a subset, the element is in the set (yes) or the element is not in the set (no)
    // which can be shown with 1s and 0s

    //  for example if the current bit number is 101 and the set is {a0 a1 a2}
    //  we will include a0 and a2 into the subset
    public ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<>();   // all of the subsets
        int max = 1 << set.size();  // maximum number of subsets is 2 ^ n

        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allsubsets.add(subset); // add the subset to all of the subsets
        }

        return allsubsets;  // return all subsets
    }

    private ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();  // keeping track of the current subset
        int index = 0;

        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) { //  if the current bit is a 1
                subset.add(set.get(index)); // we want to add the value at the specific index of the set
            }

            index++;
        }

        return subset;
    }


}











