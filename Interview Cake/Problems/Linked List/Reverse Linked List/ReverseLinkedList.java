public class ReverseLinkedList {
    public LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode current = head;
        LinkedListNode previous = null;
        LinkedListNode next = null;

        while (current != null) {
            next = current.next;

            current.next = previous;
            previous = current;

            current = next;
        }

        return previous;
    }
}