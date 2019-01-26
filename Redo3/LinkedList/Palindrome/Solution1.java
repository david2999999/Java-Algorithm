package LinkedList.Palindrome;

import CodeLibrary.LinkedListNode;

public class Solution1 {
    public boolean isPalindrome(LinkedListNode head) {
        LinkedListNode reverse = reverseAndClone(head);
        return isEqual(head, reverse);
    }

    private boolean isEqual(LinkedListNode one, LinkedListNode two) {
        while (one != null && two != null) {
            if (one.data != two.data) return false;

            one = one.next;
            two = two.next;
        }

        return one == null && two == null;
    }

    private LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;

        LinkedListNode current = node;
        while (current != null) {
            LinkedListNode n = new LinkedListNode(current.data);
            n.next = head;
            head = n;
            current = current.next;
        }

        return head;
    }
}
