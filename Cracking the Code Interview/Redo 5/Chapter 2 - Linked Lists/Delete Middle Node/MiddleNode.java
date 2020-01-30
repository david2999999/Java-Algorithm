public class MiddleNode {
    public boolean deleteNode(LinkedListNode node) {
        if (node == null || node.next == null) {
            return false;
        }

        LinkedListNode next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
    }
}