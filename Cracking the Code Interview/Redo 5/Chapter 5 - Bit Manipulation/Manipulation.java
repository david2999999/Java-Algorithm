public class Manipulation {
    public boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    public int setBit(int num, int i) {
        return num | (i << i);
    }
}