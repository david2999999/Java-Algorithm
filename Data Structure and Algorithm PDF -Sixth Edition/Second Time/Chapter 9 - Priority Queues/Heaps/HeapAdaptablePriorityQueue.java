public class HeapAdaptablePriorityQueue<K, V> extends HeapPriorityQueue<K, V>
                                            implements AdaptablePriorityQueue<K, V> {
    protected static class AdaptablePQEntry<K, V> extends PQEntry<K, V> {
        private int index;
        public AdaptablePQEntry(K key, V value, int index) {
            super(key, value);
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public HeapAdaptablePriorityQueue() {
        super();
    }

    public HeapAdaptablePriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    protected AdaptablePQEntry<K, V> validate(Entry<K, V> entry) throws IllegalArgumentException {
        if (!(entry instanceof AdaptablePQEntry))
            throw new IllegalArgumentException("Invalid entry");

        AdaptablePQEntry<K, V> locator = (AdaptablePQEntry<K, V>) entry;
        int index = locator.getIndex();

        if (index >= heap.size() || heap.get(index) != locator)
            throw new IllegalArgumentException("Invalid entry");

        return locator;
    }
}