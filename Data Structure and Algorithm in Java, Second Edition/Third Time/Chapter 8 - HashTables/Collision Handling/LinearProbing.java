public class LinearProbing {
    private static final int MASK = 0x7FFFFFFF;
    private static final int CAPACITY = 11;
    private static final size = 0;
    private static boolean[] used = new boolean[CAPACITY];

    private static int hash(Object object) {
        ++size;
        int hash = (object.hashCode() & MASK) % CAPACITY;

        while (used[hash]) {
            hash = (hash + 1) % CAPACITY;
        }
        used[hash] = true;
        return hash;
    }
}