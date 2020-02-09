public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
    private ArrayList<MapEntry<k, V>> table = new ArrayList<>();

    public UnsortedTableMap() {}

    private int findIndex(K key) {
        int n = table.size();
        for (int j = 0; j < n; j++) {
            if (table.get(j).getKey().equals(key)) {
                return j;
            }
        }

        return -1;
    }

    public int size() {
        return table.size();
    }

    public V get(K key) {
        int j = findIndex(key);
        if (j == -1) return null;
        return table.get(i).getValue();
    }
}