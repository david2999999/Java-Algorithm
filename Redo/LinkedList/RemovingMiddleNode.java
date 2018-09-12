package Redo.LinkedList;

import CodeLibrary.LinkedListNode;

public class RemovingMiddleNode {
    private boolean removeNode(LinkedListNode node) {
        if (node == null || node.next == null) return false;

        LinkedListNode next = node.next;
        node.data = next.data;
        node.next = next.next;

        return true;
    }
}
