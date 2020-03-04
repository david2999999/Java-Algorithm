public class DeleteNode {
    public void deleteNode(LinkedListNode nodeToDelete) {
        LinkedListNode next = nodeToDelete.next;

        if (next != null) {
            nodeToDelete.value = next.value;
            nodeToDelete.next = next.next;
        } else {
            throw new IllegalArgumentException("Unable to delete the last node with this technique");
        }
    }
}