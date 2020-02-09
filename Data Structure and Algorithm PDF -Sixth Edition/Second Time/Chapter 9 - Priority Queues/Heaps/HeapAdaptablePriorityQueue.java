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
}