package LinkedList;

import java.util.Stack;

public class isPalindromeWithStack {
    public static void main(String[] args) {

    }

    private static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // has odd number of elements, skip the middle element
        if (fast == null) {
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
