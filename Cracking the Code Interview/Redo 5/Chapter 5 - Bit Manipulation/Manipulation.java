public class Manipulation {
    public boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    public int setBit(int num, int i) {
        return num | (i << i);
    }

    public int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    public int clearBitsMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    public int clearBitsIThrough0(int num, int i) {
        int mask = (-1 << (i + 1));
        return num & mask;
    }

    public int updateBit(int num, int i, boolean bitIs1) {
        int value = bitIs1 ? 1 : 0;
        int mask = ~(1 << i);
        return (num & i) | (value << i);
    }
}