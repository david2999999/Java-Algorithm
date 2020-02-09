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

    public V put(K key, V value) {
        int j = findIndex(key);

        if (j == -1) {
            table.add(new MapEntry<K, V>(key, value));
            return null;
        } else {
            return table.get(j).setValue(value);
        }
    }

    public V remove(K key) {
        int index = findIndex(key);
        int lastIndex = size() - 1;

        if (index == -1) return null;

        V answer = table.get(index).getValue();
        if (index != lastIndex) {
            table.set(index, table.get(lastIndex));
        }

        table.remove(lastIndex);
        return answer;
    }
}














