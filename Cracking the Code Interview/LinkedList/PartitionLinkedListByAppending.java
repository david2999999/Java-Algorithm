package LinkedList;

public class PartitionLinkedListByAppending {
    public static void main(String[] args) {

    }

    private static LinkedListNode partition(LinkedListNode node, int k) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < k) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }

            node = next;
        }

        tail.next = null;

        return head;
    }
}
