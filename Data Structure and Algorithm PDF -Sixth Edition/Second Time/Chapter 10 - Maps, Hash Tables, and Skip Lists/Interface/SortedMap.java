public interface SortedMap<K, V> extends Map<K, V> {
    int compare(Entry<K, V> a, Entry<K, V> b);
    int compare(K a, Entry<K, V> b);
    int compare(Entry<K, V> a, K b);
    int compare(K a, K b);
}