public class KthToLast2Pointer {
    public LinkedListNode kthToLast(int k, LinkedListNode head) {
        if (k < 1) {
            throw new IllegalArgumentException("Impossible to find less than first to last node: " + k);
        }

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        for (int i = 0; i < k - 1; i++) {
            if (fast.next == null) {
                throw new IllegalArgumentException("k is larger than the length of the linked list: " + k);
            }

            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}