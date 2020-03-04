public class BitSet {
    private int[] bitSet;

    public BitSet(int size) {
        this.bitSet = new int[(size >> 5) + 1]; // the +1 is to account for size that are not multiples of 32
    }

    public boolean get(int pos) {
        int wordNumber = (pos >> 5);
        int bitNumber = (pos & 0x1F);
        return bitSet[wordNumber] & (1 << bitNumber) != 0;
    }

    public boolean set(int pos) {
        int wordNumber = (pos >> 5);
        int bitNumber = (pos & 0x1F);
        bitSet[wordNumber] |= (1 << bitNumber);
    }
}