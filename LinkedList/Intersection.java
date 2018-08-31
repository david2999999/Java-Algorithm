package LinkedList;

public class Intersection {
    public static void main(String[] args) {

    }

    private static LinkedListNode FindBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        // no meeting point and therefore no loop
        if (fast == null || fast.next == null) return null;

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // return either
        return slow;
    }
}
