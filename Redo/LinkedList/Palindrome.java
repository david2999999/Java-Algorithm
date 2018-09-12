package Redo.LinkedList;

import CodeLibrary.LinkedListNode;

public class Palindrome {
    private boolean isPalindrome(LinkedListNode node) {
        LinkedListNode reversed = reverseAndCopy(node);
        return isEqual(node, reversed);
    }

    private LinkedListNode reverseAndCopy(LinkedListNode node) {
        LinkedListNode head = null;

        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }

        return head;
    }

    private boolean isEqual(LinkedListNode n1, LinkedListNode n2) {
        while (n1 != null && n2 != null) {
            if (n1.data != n2.data) return false;

            n1 = n1.next;
            n2 = n2.next;
        }

        return n1 == null && n2 == null;
    }
}
