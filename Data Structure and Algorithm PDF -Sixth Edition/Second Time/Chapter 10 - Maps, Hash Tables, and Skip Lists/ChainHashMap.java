public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
    private UnsortedTableMap<K, V>[] table;

    public ChainHashMap() {
        super();
    }

    public ChainHashMap(int capacity) {
        super(capacity);
    }

    public ChainHashMap(int capacity, int prime) {
        super(capacity, prime);
    }

    protected void createTable() {
        table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
    }

    protected V bucketGet(int hash, K key) {
        UnsortedTableMap<K, V> bucket = table[hash];
        if (bucket == null) return null;
        return bucket.get(key);
    }

    protected V bucketPut(int hash, K key, V value) {
        UnsortedTableMap<K, V> bucket = table[hash];
        if (bucket == null) {
            bucket = table[hash] = new UnsortedTableMap<>();
        }

        int oldSize = bucket.size();
        V answer = bucket.put(key, value);
        entries += (bucket.size() - oldSize);
        return answer;
    }

    protected V bucketRemove(int hash, K key) {
        UnsortedTableMap<K, V> bucket = table[hash];
        if (bucket == null) return null;
        int oldSize = bucket.size();
        V answer = bucket.remove(key);
        entries -= (oldSize - bucket.size());
        return answer;
    }

    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (int h = 0; h < capacity; h++) {
            if (table[h] != null) {
                for (Entry<K, V> entry: table[h].entrySet()) {
                    buffer.add(entry);
                }
            }
        }

        return buffer;
    }
}