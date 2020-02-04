public class HashTable {
    private static final int MASK = 0x7FFFFFFF;
    private static int capacity = 101;
    private static float laod = 0.75F;
    private static LinkedList[] buckets;

    public HashTable() {
        this.buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList();
        }
    }

    public HashTable(int capacity, float load) {
        this();
        this.capacity = capacity;
        this.load = load;
    }

    public Object put(Object key, Object value) {
        int hash = hash(key);
        LinkedList bucket = buckets[hash];
        Map.Entry entry = null;

        for (ListIterator it = bucket.iterator(); it.hasNext(); ) {
            entry = it.next();
            if (entry.getKey().equals(key)) break;
        }

        if (entry != null && entry.getKey.equals(key)) {
            return entry.setValue(value);
        } else {
            bucket.add(new Entry(key, value));
        }

        return null;
    }

    private int hash(Object object) {
        return (object.hashCode() & MASK) % CAPACITY;
    }
}