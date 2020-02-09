public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
    private static final int NOT_FOUND = -1;
    private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    public UnsortedTableMap() {}

    private int findIndex(K key) {
        int size = table.size();
        for (int index = 0; index < size; index++) {
            if (table.get(index).getKey().equals(key)) {
                return index;
            }
        }

        return NOT_FOUND;
    }

    public int size() {
        return table.size();
    }

    public V get(K key) {
        int index = findIndex(key);
        if (index == NOT_FOUND) return null;
        return table.get(i).getValue();
    }

    public V put(K key, V value) {
        int index = findIndex(key);

        if (index == NOT_FOUND) {
            table.add(new MapEntry<K, V>(key, value));
            return null;
        } else {
            return table.get(index).setValue(value);
        }
    }

    public V remove(K key) {
        int index = findIndex(key);
        int lastIndex = size() - 1;

        if (index == NOT_FOUND) return null;

        V answer = table.get(index).getValue();
        if (index != lastIndex) {
            table.set(index, table.get(lastIndex));
        }

        table.remove(lastIndex);
        return answer;
    }
}














