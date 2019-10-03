package LinkedList;

import CodeLibrary.LinkedListNode;

import java.util.Stack;

// function to check if a linked list is a palindrome
// 0 -> 1 -> 2 -> 1 -> 0
public class PalindomeLinkedListIterative {
    // this example will use a stack to store the data from the nodes
    // there will be a slow and fast pointer
    // the slow pointer moves forward the list 1 at a time
    // the fast pointer moves forward the list 2 at a time

    public boolean isPalindrome(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<>();

        // when the fast node reaches the end, the stack will
        // have half of the number of nodes from the list
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // there are an odd number of elements
        // skip the middle element
        // for example if there is // 0 -> 1 -> 2 -> 1 -> 0
        // we would not care about the middle 2
        if (fast != null) {
            slow = slow.next;
        }

        // remember the slow pointer is a node after the middle node
        // 0 -> 1 -> 2 -> 1 -> 0. In this case, the slow pointer will be at
        // the second 1.
        while (slow != null) {
            int top = stack.pop().intValue();

            if (top != slow.data) { // comparing the values from the stack with the node data
                return false;
            }

            slow = slow.next;
        }

        return true;    // all values of the stack matches the slow pointer
    }
}














