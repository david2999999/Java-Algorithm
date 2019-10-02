package ObjectOrientedDesign.HashTable;

import java.util.ArrayList;

public class Hasher<K, V> {
    private static class LinkedListNode<K, V> {
        public LinkedListNode<K, V> next;
        public LinkedListNode<K, V> prev;
        public K key;
        public V value;

        public LinkedListNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<LinkedListNode<K, V>> arr;

    public Hasher(int capacity) {
        arr = new ArrayList<>();
        arr.ensureCapacity(capacity);
        for (int i = 0; i < capacity; i++) {
            arr.add(null);
        }
    }

    public V put(K key, V value) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node != null) {
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }

        node = new LinkedListNode<>(key, value);
        int index = getIndexForKey(key);
        if (arr.get(index) != null) {
            node.next = arr.get(index);
            node.next.prev = node;
        }

        arr.set(index, node);
        return null;
    }

    public V remove(K key) {
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node == null) return null;

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            int hashKey = getIndexForKey(key);
            arr.set(hashKey, node.next);
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        return node.value;
    }

    public V get(K key) {
        if (key == null) return null;
        LinkedListNode<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }


    private LinkedListNode<K,V> getNodeForKey(K key) {
        int index = getIndexForKey(key);
        LinkedListNode<K, V> current = arr.get(index);

        while (current != null) {
            if (current.key == key) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    private int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % arr.size());
    }
}
