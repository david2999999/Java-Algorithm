package Moderate;

import java.util.HashMap;

// Design and build a least recently used cache, which evicts the recently used item.
// The cache cache should map from keys to values. Include these functionality
// 1) Inserting key, value pair
// 2) Retrieve a key by value
// 3) Finding least recently used
// 4) Updating most recently used
// 5) removing least recently used element when the cache reach max capacity
public class LRUCache {
    // for the key value pair, we will use a HashMap
    // to implement the least/most recently used we will use a doubly linked list

    private static class LinkedListNode {
        private LinkedListNode next, prev;
        public int key;
        public String value;

        public LinkedListNode(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private int maxCacheSize;
    private HashMap<Integer, LinkedListNode> map = new HashMap<>();
    private LinkedListNode listHead = null; // the head of the linked list, or the most recently used node
    private LinkedListNode listTail = null; // the tail of the linked list, or the least recently used node

    public LRUCache(int maxCacheSize) {
        this.maxCacheSize = maxCacheSize;
    }

    // getting a value using a key
    public String getValue(int key) {
        // O(1) search time using HashMap
        LinkedListNode item = map.get(key);
        if (item == null) return null;  // the node does not exist, so no value

        if (item != listHead) { // if the item is not most recently used
            removeFromLinkedList(item); // remove the node from the LinkedList
            insertAtFrontOfLinkedList(item);    // insert the node to the from of the LinkedList
        }

        return item.value;  // returning the value of the node
    }

    public boolean removeKey(int key) {
        LinkedListNode node = map.get(key);
        removeFromLinkedList(node); // remove the node from the list
        map.remove(key);    // remove the key and value from the map
        return true;
    }

    public void setKeyValue(int key, String value) {
        // remove if already in the map or list
        removeKey(key);

        // if the map is full and the tail is not equal to null
        if (map.size() >= maxCacheSize && listTail != null) {
            removeKey(listTail.key);    // remove the tail to add space for the new node
        }

        LinkedListNode node = new LinkedListNode(key, value);
        insertAtFrontOfLinkedList(node);    // make this new node, most recently used node
        map.put(key, node); // add the node into the map
    }


    private void insertAtFrontOfLinkedList(LinkedListNode node) {
        // if the head does not exist, the list is empty
        // set the head and tail to the node
        if (listHead == null) {
            listHead = node;
            listTail = node;
        } else {
            listHead.prev = node;   // set the node before the head of the list
            node.next = listHead;   // set the next element of the node to be the head
            listHead = node;        // the node is now the head of the list
        }
    }

    private void removeFromLinkedList(LinkedListNode node) {
        if (node == null) return;

        // doubly connection
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;

        // if the node is the tail, set the tail to the element before the current node
        if (node == listTail) listTail = node.prev;
        // if the node is the head, set the head to the element after the current node
        if (node == listHead) listHead = node.next;
    }
}









