public class DetectCycle {
    public boolean containsCycle(LinkedListNode firstNode) {
        LinkedListNode slow = firstNode;
        LinkedListNode fast = firstNode;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}