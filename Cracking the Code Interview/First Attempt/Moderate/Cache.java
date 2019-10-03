package Moderate;

import CodeLibrary.LinkedListNodeString;

import java.util.HashMap;

public class Cache {
    private int maxCacheSize;
    private HashMap<Integer, LinkedListNodeString> map = new HashMap<>();
    private LinkedListNodeString listHead = null;
    private LinkedListNodeString listTail = null;

    public Cache(int maxSize) {
        this.maxCacheSize = maxSize;
    }

    public String getValue(int key) {
        LinkedListNodeString item = map.get(key);
        if (item == null) return null;

        if (item != listHead) {
            removeFromLinkedList(item);
            insertAtFrontOfLinkedList(item);
        }

        return item.value;
    }

    private void insertAtFrontOfLinkedList(LinkedListNodeString node) {
        if (listHead == null) {
            listHead = node;
            listTail = node;
        } else {
            listHead.prev = node;
            node.next = listHead;
            listHead = node;
        }
    }

    public boolean removeKey(int key) {
        LinkedListNodeString node = map.get(key);
        if (node == null) return false;

        removeFromLinkedList(node);
        map.remove(key);
        return true;
    }

    public void setKeyValue(int key, String value) {
        removeKey(key);

        if (map.size() >= maxCacheSize && listTail != null) {
            removeKey(listTail.key);
        }

        LinkedListNodeString node = new LinkedListNodeString(key, value);
        map.put(key, node);
        insertAtFrontOfLinkedList(node);
    }

    private void removeFromLinkedList(LinkedListNodeString node) {
        if (node == null) return;

        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;

        if (node == listHead) listHead = node.next;
        if (node == listTail) listTail = node.prev;
    }
}
