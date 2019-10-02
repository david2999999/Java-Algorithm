package LinkedList;

public class FindingKthFromLastUsingWrapperIndex {
    public static void main(String[] args) {

    }

    private static LinkedListNode kthToLast(LinkedListNode head, int k) {
        Index index = new Index();
        return kthToLast(head, k, index);
    }

    private static LinkedListNode kthToLast(LinkedListNode head, int k, Index index) {
        if (head == null) {
            return null;
        }

        LinkedListNode node = kthToLast(head, k, index);
        index.value += 1;

        if (index.value == k) {
            return head;
        }

        return node;
    }
}
