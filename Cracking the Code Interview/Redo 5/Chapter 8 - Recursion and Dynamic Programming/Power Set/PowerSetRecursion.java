public class PowerSetRecursion {
    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
        return getSubsets(set, 0);
    }

    private ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;

        if (set.size() == index) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new Arraylist<>());
        } else {
            allSubsets = getSubsets(set, index + 1);
            int item = set.get(index);

            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();

            for (ArrayList<Integer> subset: allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }

            allSubsets.add(moreSubsets);
        }

        return allSubsets;
    }
}