public abstract class AbstractSortedMap<K, V>
        extends AbstractMap<K, V> implements SortedMap<K, V> {
    private Comparator<K> comp;

    protected AbstractSortedMap(Comparator<K> comparator) {
        this.comp = comparator;
    }

    protected AbstractSortedMap() {
        this(new DefaultComparator<K>());
    }

    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    protected int compare(K a, Entry<K, V> b) {
        return comp.compare(a, b.getKey());
    }

    protected int compare(Entry<K, V> a, K b) {
        return comp.compare(a.getKey(), b);
    }

    protected int compare(K a, K b) {
        return comp.compare(a, b);
    }

    protected boolean checkKey(K key) throw IllegalArgumentException {
        try {
            return (comp.compare(key, key) == 0);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key.");
        }
    }


}