public class PowerSetCombinatorics {
    public ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();

        int maxNum = 1 << set.size();
        for (int k = 0; k < maxNum; k++) {
            ArrayList<Integer> subset = createSubsetFromInteger(k, set);
            allSubsets.add(subset);
        }

        return allSubsets;
    }

    private ArrayList<Integer> createSubsetFromInteger(int num, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();

        int index = 0;
        for (int k = num; k > 0; k >>= 1) {
            if (k & 1 == 1) {
                subset.add(set.get(index));
            }
            index++;
        }

        return subset;
    }
}