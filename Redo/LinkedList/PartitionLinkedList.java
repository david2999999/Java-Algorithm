package Redo.LinkedList;

import CodeLibrary.LinkedListNode;

public class PartitionLinkedList {
    private LinkedListNode partition(LinkedListNode node, int k) {
        LinkedListNode leftStart = null;
        LinkedListNode leftEnd = null;
        LinkedListNode rightStart = null;
        LinkedListNode rightEnd = null;

        while (node != null) {
            LinkedListNode next = node.next;
            node.next = null;

            if (node.data < k) {
                if (leftStart == null) {
                    leftStart = node;
                    leftEnd = leftStart;
                } else {
                    leftEnd.next = node;
                    leftEnd = node;
                }
            } else {
                if (rightStart == null) {
                    rightStart = node;
                    rightEnd = node;
                } else {
                    rightEnd.next = node;
                    rightEnd = node;
                }
            }

            node = next;
        }

        if (leftStart == null) return rightStart;

        leftEnd.next = rightStart;
        return leftStart;
    }
}
