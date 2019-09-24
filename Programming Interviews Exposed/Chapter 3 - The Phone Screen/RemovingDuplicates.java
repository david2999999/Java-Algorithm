public class RemovingDuplicates {
    public Set<Integer> removeDuplicates(ArrayList<Integer> integers) {
        Set<Integer> noDuplicates = new HashSet<>();
        for (Integer integer: integers) {
            noDuplicates.add(integer);
        }

        return noDuplicates;
    }

    public static void main(String args[]) {
        RemovingDuplicates removingDuplicates = new RemovingDuplicates();
        ArrayList<Integer> integers = new ArrayList<>();

        integers.add(3);
        integers.add(10);
        integers.add(1);
        integers.add(45);
        integers.add(644);
        integers.add(3);
        integers.add(3);
        integers.add(3);
        integers.add(3);

        Set<Integer> noDuplicates = removingDuplicates.removeDuplicates(integers);
        System.out.println(noDuplicates);
    }
}





