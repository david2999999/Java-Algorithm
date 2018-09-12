package Redo.LinkedList;

import CodeLibrary.LinkedListNode;

import java.util.Stack;

public class PalindromeWithStack {
    private boolean isPalindrome(LinkedListNode head) {
        if (head == null) return false;

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);

            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop();

            if (top != slow.data) return false;

            slow = slow.next;
        }

        return true;
    }
}
