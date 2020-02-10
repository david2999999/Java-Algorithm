public class HashMultimap<K, V> {
    Map<K, List<V>> map = new HashMap<>();
    int total = 0;

    public HashMultimap() {}

    public int size() {
        return total;
    }

    public boolean isEmpty() {
        return total == 0;
    }

    public Iterable<V> get(K key) {
        List<V> secondary = map.get(key);

        if (secondary != null) {
            return secondary;
        }

        return new ArrayList<>();
    }

    public void put(K key, V value) {
        List<V> secondary = map.get(key);
        if (secondary == null) {
            secondary = new ArrayList<>();
            map.put(key, secondary);
        }

        secondary.add(value);
        total++;
    }

    public boolean remove(K key, V value) {
        boolean wasRemoved = false;
        List<V> secondary = map.get(key);
        if (secondary != null) {
            wasRemoved = secondary.remove(value);

            if (wasRemoved) {
                total--;
                if (secondary.isEmpty()) {
                    map.remove(key);
                }
            }
        }

        return wasRemoved;
    }

    public Iterable<V> removeAll(K key) {
        List<V> secondary = map.get(key);
        if (secondary != null) {
            total -= secondary.size();
            map.remove(key);
        } else {
            secondary = new ArrayList<>();
        }

        return secondary;
    }
}









