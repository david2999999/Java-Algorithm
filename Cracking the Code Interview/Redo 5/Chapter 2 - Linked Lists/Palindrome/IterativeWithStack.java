public class IterativeWithStack {
    public boolean isPalindrome(LinkedListNode node) {
        if (node == null) return false;

        Stack<Integer> stack = new Stack<>();
        LinkedListNode slow = node;
        LinkedListNode fast = node;

        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next();
        }

        while (slow != null) {
            int top = stack.pop().intValue();
            if (slow.data != top) return false;
            slow = slow.next;
        }

        return true;
    }
}