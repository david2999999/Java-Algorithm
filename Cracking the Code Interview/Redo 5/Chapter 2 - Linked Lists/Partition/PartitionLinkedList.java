public class PartitionLinkedList {
    public LinkedListNode parition(LinkedListNode head, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        LinkedListNode current = head;
        LinkedListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = null;

            if (current.data < x) {
                insertElementToList(current, beforeStart, beforeEnd);
            } else {
                insertElementToList(current, afterStart, afterEnd);
            }

            current = next;
        }

        if (beforeStart == null) return afterStart;

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    public void insertElementToList(LinkedListNode element, LinkedListNode head, LinkedListNode tail) {
        if (head == null) {
            head = element;
            tail = head;
        } else {
            tail.next = element;
            tail = element;
        }
    }
}