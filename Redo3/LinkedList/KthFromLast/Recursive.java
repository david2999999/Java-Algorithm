package LinkedList.KthFromLast;

import CodeLibrary.LinkedListNode;

public class Recursive {
    public int printKthToLast(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }

        int index = printKthToLast(head.next, k) + 1;

        if (index == k) {
            System.out.println("Found the k th node " + head.data);
        }

        return index;
    }
}
