package SortingAndSearching.FindDuplicates;

public class Duplicates {
    public void checkDuplicates(int[] array) {
        BitSet bitSet = new BitSet(32000);

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num - 1;

            if (bitSet.get(num0)) {
                System.out.println(num);
            } else {
                bitSet.set(num0);
            }
        }
    }
}
