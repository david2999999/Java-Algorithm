public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
    protected int n = 0;
    protected int capacity;
    private int prime;
    private long scale, shift;
    
    public AbstractHashMap(int cap, int p) {
        prime = p;
        capacity = cap;
        Random rand = new Random();
        scale = rand.nextInt(prime - 1) + 1;
        shift = rand.nextInt(prime);
        createTable();
    }
    
    public AbstractHashMap(int cap) { this(cap, 109345121); }
    public AbstractHashMap() { this(17); }
    
    public int size() { return n; }
    public V get(K key) { return bucketGet(hashValue(key), key); }
    public V remove(K key) { return bucketRemove(hashValue(key), key); }
    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);
        if (n > capacity / 2) {
            resize(2 * capacity - 1);
        } 
        
        return answer;
    }
    
    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode()*scale + shift) % prime) % capacity);
    }
}