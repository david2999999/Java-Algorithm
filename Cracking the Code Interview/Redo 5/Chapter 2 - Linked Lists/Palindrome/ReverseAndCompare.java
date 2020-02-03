public class ReverseAndCompare {
    public boolean isEqual(LinkedListNode head) {
        LinkedListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    public boolean isEqual(LinkedListNode original, LinkedListNode reversed) {
        while (original != null && reversed != null) {
            if (original.data != reversed.data) return false;

            original = original.next;
            reversed = reversed.next;
        }

        return true;
    }

    private LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;

        while (node != null) {
            LinkedListNode newNode = new LinkedListNode(node.data);
            newNode.next = head;
            head = newNode;
            node = node.next;
        }

        return head;
    }
}