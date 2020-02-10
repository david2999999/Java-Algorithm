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
}