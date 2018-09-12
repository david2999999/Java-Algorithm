package Redo.LinkedList;

import CodeLibrary.LinkedListNode;

public class FindingKthOfLast {
    private int findKthElement(LinkedListNode head, int k) {
        if (head == null) return 0;

        int index = findKthElement(head.next, k) + 1;
        if (index == k) {
            System.out.println("Found the kth from last element: " + head.data);
        }

        return index;
    }
}
