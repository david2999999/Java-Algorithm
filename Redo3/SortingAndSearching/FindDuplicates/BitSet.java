package SortingAndSearching.FindDuplicates;

public class BitSet {
    private int[] bitset;

    public BitSet(int size) {
        bitset = new int[(size >> 5) + 1];
    }

    public boolean get(int pos) {
        int wordNumber = (pos >> 5);
        int bitNumber = (pos & 0x1F);
        return (bitset[wordNumber] & (1 << bitNumber)) != 0;
    }

    public void set(int pos) {
        int wordNumber = (pos >> 5);
        int bitNumber = (pos & 0x1F);
        bitset[wordNumber] |= (1 << bitNumber);
    }
}
