public class KthToLastLengthApproach {
    public LinkedListNode kthToLastNode(int k, LinkedListNode head) {
        if (k < 1) {
            throw new IllegalArgumentException("Impossible to find less than first node to last: " + k);
        }

        int length = 1;
        LinkedListNode current = head;

        while (current.next != null) {
            current = current.next;
            length++;
        }

        if (k > length) {
            throw new IllegalArgumentException("K is larger than the length of the linked list: " + k);
        }

        int pathLength = length - k;
        current = head;

        for (int i = 0; i < pathLength; i++) {
            current = current.next;
        }

        return current;
    }
}