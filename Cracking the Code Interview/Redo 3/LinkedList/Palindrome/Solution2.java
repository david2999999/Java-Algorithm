package LinkedList.Palindrome;

import CodeLibrary.LinkedListNode;

import java.util.Stack;

public class Solution2 {
    public boolean isPalindrome(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop();

            if (slow.data != top) {
                return false;
            }

            slow = slow.next;
        }

        return true;
    }
}
