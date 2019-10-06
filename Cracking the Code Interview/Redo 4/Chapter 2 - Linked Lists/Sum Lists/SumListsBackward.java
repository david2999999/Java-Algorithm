public class SumListsBackward {
    private class PartialSum {
        public LinkedListNode sum = null;
        public int carry = 0;
    }

    public LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }

        PartialSum sum = addListsHelper(l1, l2);

        if (sum.carry == 0) {
            return sum.sum;
        } else {
            LinkedListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    private PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            return new PartialSum();
        }

        PartialSum sum = addListsHelper(l1.next, l2.next);

        int value = sum.carry + l1.data + l2.data;

        LinkedListNode fullResult = insertBefore(sum.sum, value % 10);

        sum.sum = fullResult;
        sum.carry = val / 10;
        return sum;
    }

    private LinkedListNode padList(LinkedListNode node, int padding) {
        LinkedListNode head = node;

        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }

        return head;
    }

    private LinkedListNode insertBefore(LinkedList list, int data) {
        LinkedListNode node = new LinkedListNoded(data);

        if (list != null) {
            node.next = list;
        }

        return node;
    }

    private int length(LinkedListNode head) {
        int length = 0;
        LinkedListNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }
}