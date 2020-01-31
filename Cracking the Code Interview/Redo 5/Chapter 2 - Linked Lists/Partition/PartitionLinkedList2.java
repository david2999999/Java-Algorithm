public class PartitionLinkedList2 {
    public LinkedListNode partition(LinkedListNode node, int x) {
        if (node == null) return null;

        LinkedListNode head = node;
        LinkedListNode tail = node;

        LinkedListNode current = node;
        while (current != null) {
            next = current.next;

            if (current.data < x) {
                current.next = head;
                head = current;
            } else {
                tail.next = current;
                tail = current;
            }

            current = next;
        }

        tail.next = null;

        return head;
    }
}