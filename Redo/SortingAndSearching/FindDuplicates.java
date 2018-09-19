package Redo.SortingAndSearching;

public class FindDuplicates {

    private void printDuplicates(int[] arr) {
        BitSet set = new BitSet(3200);

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int num0 = num - 1;
            if (set.get(num0)) {
                System.out.println(num);
            } else {
                set.set(num0);
            }
        }
    }


    private class BitSet {
        private int[] bitset;

        public BitSet(int size) {
            bitset = new int[(size >> 5) + 1];
        }

        public boolean get(int pos) {
            int wordNumber = pos >> 5;
            int bitNumber = pos & 0x1F;
            return (bitset[wordNumber] & (1 << bitNumber)) != 0;
        }

        public void set(int pos) {
            int wordNumber = pos >> 5;
            int bitNumber = pos & 0x1F;
            bitset[wordNumber] |= (1 << bitNumber);
        }

    }
}
