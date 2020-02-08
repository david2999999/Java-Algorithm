public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
    protected static class PQEntry<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        public PQEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private Comparator<K> comp;

    protected AbstractPriorityQueue(Comparator<K> c) {
        comp = c;
    }

    protected AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    }

    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (com.compare(key, key) == 0);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}