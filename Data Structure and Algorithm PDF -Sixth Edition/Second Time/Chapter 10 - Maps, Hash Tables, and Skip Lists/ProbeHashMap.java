public class ProbeHashMap<K, V> extends AbstractHashMap<K, V> {
    private MapEntry<K, V>[] table;
    private MapEntry<K, V> DEFUNCT = new MapEntry<>(null, null);

    public ProbeHashMap() {
        super();
    }

    public ProbeHashMap(int capacity) {
        super(capacity);
    }

    public ProbeHashMap(int capacity, int prime) {
        super(capacity, prime);
    }

    private boolean isAvailable(int j) {
        return (table[j] == null || table[j] == DEFUNCT);
    }

    private int findSlot(int hash, K key) {
        int avail = -1;
        int currentIndex = hash;

        do {
            if (isAvailable(currentIndex)) {
                if (avail == -1) avail = currentIndex;
                if (table[currentIndex] == null) break;
            } else if (table[currentIndex].getKey().equals(key)) {
                return currentIndex;
            }

            currentIndex = (currentIndex + 1) % capacity;
        } while (currentIndex != hash);

        return -(avail + 1); // search failed
    }

    protected V bucketGet(int hash, int key) {
        int index = findSlot(hash, key);
        if (index < 0) return null;
        return table[index].getValue();
    }

    protected V bucketPut(int hash, K key, V value) {
        int index = findSlot(hash, key);
        if (index >= 0) {
            return table[index].setValue[value];
        }

        table[-(index + 1)] = new MapEntry<>(key, value);
        entries++;
        return null;
    }

    protected V bucketRemove(int hash, K key) {
        int index = findSlot(hash, key);
        if (index < 0) return null;
        V answer = table[index].getValue();
        table[index] = DEFUNCT;
        entries--;
        return answer;
    }

    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (int index = 0; index < capacity; index++) {
            if (!isAvailable(index)) {
                buffer.add(table[index]);
            }
        }

        return buffer;
    }
}













