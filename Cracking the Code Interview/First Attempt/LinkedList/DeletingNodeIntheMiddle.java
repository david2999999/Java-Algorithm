package LinkedList;

public class DeletingNodeIntheMiddle {
    public static void main(String[] args) {

    }

    private static boolean deleteNode(LinkedListNode node) {
        if (node == null || node.next == null) return false;

        LinkedListNode next = node.next;
        node.data = next.data;
        node.next = next.next;

        return true;
    }
}
