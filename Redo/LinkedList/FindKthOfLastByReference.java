package Redo.LinkedList;

import CodeLibrary.LinkedListNode;

public class FindKthOfLastByReference {
    private class Index {
        public int value = 0;
    }

    private LinkedListNode findKth(LinkedListNode head, int k) {
        Index index = new Index();
        return findKth(head, k, index);
    }

    private LinkedListNode findKth(LinkedListNode head, int k, Index idx) {
        if (head == null) return null;

        LinkedListNode node = findKth(head, k, idx);
        idx.value += 1;

        if (idx.value == k) return head;

        return node;
    }
}
