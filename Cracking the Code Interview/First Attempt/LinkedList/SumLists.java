package LinkedList;

public class SumLists {
    public static void main(String[] args) {

    }

    private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

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

    private static PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }

        PartialSum sum = addListsHelper(l1.next, l2.next);

        int val = sum.carry + l1.data + l2.data;

        LinkedListNode fullResult = insertBefore(sum.sum, val % 10);
        sum.sum = fullResult;
        sum.carry = val / 10;
        return sum;
    }

    private static LinkedListNode padList(LinkedListNode l, int padding) {
        LinkedListNode head = l;
        for (int i = 0; i < padding; i++) {
            insertBefore(head, 0);
        }

        return head;
    }

    private static LinkedListNode insertBefore(LinkedListNode list, int data) {
        LinkedListNode node = new LinkedListNode(data);
        if (list != null) {
            node.next = list;
        }

        return node;
    }

    private static int length(LinkedListNode node) {
        int count = 0;
        while (node != null)
        {
            count++;
            node = node.next;
        }
        return count;
    }

}
