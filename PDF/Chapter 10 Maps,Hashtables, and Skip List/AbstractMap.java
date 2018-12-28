public abstract class AbstractMap<K, V> implements Map<K, V> {
    public boolean isEmpty() {
        return size() == 0;
    }
    
    protected static class MapEntry<K, V> implements Entry<K, V> {
        private K k;
        private V v;
        
        public MapEntry(K key, V value) {
            k = key;
            v = value;
        }
        
        public K getKey() { return k; }
        public V getValue() { return v; }
    
        protected void setKey(K key) { k = key; }
        protected V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }
    }
}