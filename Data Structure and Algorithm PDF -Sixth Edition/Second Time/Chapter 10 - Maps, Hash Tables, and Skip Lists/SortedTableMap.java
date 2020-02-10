public class SortedTableMap<K, V> extends AbstractSortedMap<K, V> {
    private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    public SortedTableMap() {
        super();
    }

    public SortedTableMap(Comparator<K> comp) {
        super(comp);
    }

    private int findIndex(K key, int low, int high) {
        if (high < low) return high + 1;

        int mid = (low + high) / 2;
        int comp = compare(key, table.get(mid));

        if (comp == 0) {
            return mid;
        } else if (comp < 0) {
            return findIndex(key, low, mid - 1);
        } else {
            return findIndex(key, mid + 1, high);
        }
    }

    private int findIndex(K key) {
        return findIndex(key, 0, table.size() - 1);
    }

    public int size() {
        return table.size();
    }

    public V get(K key) {
        int index = findIndex(key);
        if (index == size() || compare(key, table.get(index)) != 0) return null;
        return table.get(index).getValue();
    }

    public V put(K key, V value) {
        int index = findIndex(key);
        if (index < size() && compare(key, table.get(index)) == 0) {
            return table.get(index).setValue(value);
        }

        table.add(index, new MapEntry<K, V>(key, value));
        return null;
    }

    public V remove(K key) {
        int index = findIndex(key);
        if (index == size() || compare(key, table.get(index)) != 0) {
            return null;
        }

        return table.remove(index).getValue();
    }

    private Entry<K, V> safeEntry(int index) {
        if (index < 0 || index >= table.size()) return null;
        return table.get(index);
    }

    public Entry<K, V> firstEntry() {
        return safeEntry(0);
    }

    public Entry<K, V> lastEntry() {
        return safeEntry(table.size() - 1);
    }

    public Entry<K, V> ceilingEntry(K key) {
        return safeEntry(findIndex(key));
    }

    public Entry<K, V> floor(K key) {
        int index = findIndex(key);
        if (index == size() || !key.equals(table.get(index).getKey())) {
            index--;
        }

        return safeEntry(index);
    }

    public Entry<K, V> lowerEntry(K key) {
        return safeEntry(findIndex(key) - 1);
    }

    public Entry<K, V> higherEntry(K key) {
        int index = findIndex(key);
        if (index < size() && key.equals(table.get(index).getKey())) {
            index++;
        }

        return safeEntry(index);
    }

    private Iterable<Entry<K, V>> snapshot(int startIndex, K stop) {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        int currentIndex = startIndex;

        while (currentIndex < table.size() &&
                (stop == null || compare(stop, table.get(currentIndex)) > 0)) {
            buffer.add(table.get(currentIndex++));
        }

        return buffer;
    }

    public Iterable<Entry<K, V>> entrySet() {
        return snapshot(0, null);
    }

    public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) {
        return snapshot(findIndex(fromKey), toKey);
    }
}