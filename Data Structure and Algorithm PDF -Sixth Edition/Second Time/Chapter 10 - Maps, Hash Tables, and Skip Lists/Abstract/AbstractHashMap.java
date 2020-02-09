public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
    protected int entries = 0;
    protected int capacity;
    private int prime;
    private long scale, shift;

    public AbstractHashMap(int capacity, int prime) {
        this.prime = prime;
        this.capacity = capacity;
        Random random = new Random();
        scale = rand.nextInt(prime - 1) + 1;
        shift = rand.nextInt(prime);
        createTable();
    }

    public AbstractHashMap(int capacity) {
        this(capacity, 109345121);
    }

    public AbstractHashMap() {
        this(17);
    }

    public int size() {
        return entries;
    }

    public V get(V key) {
        return bucketGet(hashValue(key), key);
    }

    public V remove(K key) {
        return bucketRemove(hashValue(key, key));
    }

    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);
        if (entries > capacity / 2) {
            resize(2 * capacity - 1);
        }
        return answer;
    }

    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    }

    private void resize(int newCap) {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(n);
        for (Entry<K, V> entry: entrySet()) {
            buffer.add(e);
        }

        capacity = newCap;
        createTable();
        n = 0;

        for (Entry<K, V> entry: buffer) {
            put(e.getKey(), e.getValue());
        }
    }

    protected abstract void createTable();
    protected abstract V bucketGet(int hash, K key);
    protected abstract V bucketPut(int hash, K key, V value);
    protected abstract V bucketRemove(int hash, K key);
}











