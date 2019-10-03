package SortingAndSearching;

public class FindDuplicates {
    private void findingDuplicates (int[] array){
        BitSet bs = new BitSet(3200);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num - 1; // bitset starts at 0, numbers start at 1
            if (bs.get(num0)) {
                System.out.println(num);
            } else {
                bs.set(num0);
            }
        }
    }


    private class BitSet {
        int[] bitSet;

        public BitSet(int pos) {
            bitSet = new int[(pos >> 5) + 1]; // divide by 32
        }

        public boolean get(int pos) {
            int wordNumber = pos >> 5;
            int bitNumber = pos & 0x1f; // mod 32
            return (bitSet[wordNumber] & (1 << bitNumber)) != 0;
        }

        public void set(int pos) {
            int wordNumber = pos >> 5;
            int bitNumber = pos & 0x1f;
            bitSet[wordNumber] |= (1 << bitNumber);
        }
    }
}
