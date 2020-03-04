public class FindDuplicate {
    private static final int MAX_VALUE = 32000;

    public void checkDuplicates(int[] array) {
        BitSet bs = new BitSet(MAX_VALUE);

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num - 1;

            if (bs.getBit(num0)) {
                System.out.println(num);
            } else {
                bs.set(num0);
            }
        }
    }
}