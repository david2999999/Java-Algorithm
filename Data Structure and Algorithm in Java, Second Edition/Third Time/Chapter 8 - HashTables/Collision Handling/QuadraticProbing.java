public class QuadraticProbing {
    private static final int MASK = 0x7FFFFFFF;
    private static final int CAPACITY = 11;
    private static final size = 0;
    private static boolean[] used = new boolean[CAPACITY];

    private static int hash(Object object) {
        size++;
        int hash = (object.hashCode & MASK) % CAPACITY;

        if (used[hash]) {
            int baseHash = hash;
            int jump = 1;

            while (used[hash]) {
                hash = (baseHash + jump * jump) % CAPACITY;
                jump++;
            }
        }

        used[hash] = true;
        return hash;
    }
}