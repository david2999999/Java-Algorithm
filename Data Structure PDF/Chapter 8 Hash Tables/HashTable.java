public class HashTable {
private static final int MASK = 0x7FFFFFFF; // 2^32-1
    private static int capacity = 101;
    private static int size = 0;
    private static float load = 0.75F;
    private static LinkedList[] buckets;
    
    HashTable() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList();
        }
    }
    
    HashTable(int capacity, float load) {
        this();
        this.capacity = capacity;
        this.load = load;
    }
    
    Object put(Object key, Object value) {
        int h = hash(key);
        LinkedList bucket=buckets[h];
        Object oldValue = null;
        
        for (ListIterator it = bucket.iterator(); it.hasNext(); ) {
            Map.Entry entry = it.next();
            if (entry.getKey().equals(key)) {
                break;
            }
        }
        if (entry.getKey().equals(key)) {
            oldValue = entry.setValue(value);
        } else {
            bucket.add(new Entry(key,value));
        }
        return oldValue;
    }
    
    // more methods...
}