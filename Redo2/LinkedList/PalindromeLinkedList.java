package LinkedList;

import CodeLibrary.LinkedListNode;

// function to check if a linked list is a palindrome
// 0 -> 1 -> 2 -> 1 -> 0
public class PalindromeLinkedList {
    public boolean isPalindrome(LinkedListNode head) {
        LinkedListNode reversed = reverseAndClone(head);    // reverse the linked list
        return isEqual(head, reversed); // checking if the reverse list is equal to the original list
    }

    private boolean isEqual(LinkedListNode one, LinkedListNode two) {
        while (one != null && two != null) {
            if (one.data != two.data) { // the data is not equal, so it is not a palindrome
                return false;
            }

            // move both of the pointers to the next node
            one = one.next;
            two = two.next;
        }

        // if both of them are null, then all of the data are equals. The list is a palindrome
        return one == null && two == null;
    }

    private LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null; // new reversed list

        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data);   // new node with the data from the node
            n.next = head;  // prepend the node to the head
            head = n;
            node = node.next;   // move to the next node
        }

        return head;    // the head of the reversed list
    }
}
