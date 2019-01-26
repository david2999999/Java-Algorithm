package LinkedList.SumList;

import CodeLibrary.LinkedListNode;

public class Solution2 {
    public LinkedListNode addList(LinkedListNode l1, LinkedListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }

        PartialSum sum = addListHelper(l1, l2);

        if (sum.carry == 0) {
            return sum.sum;
        } else {
            LinkedListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    private PartialSum addListHelper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }

        PartialSum sum = addListHelper(l1, l2);

        int value = sum.carry + l1.data + l2.data;

        LinkedListNode full_result = insertBefore(sum.sum, value % 10);

        sum.sum = full_result;
        sum.carry = value / 10;
        return sum;
    }

    private LinkedListNode padList(LinkedListNode n, int padding) {
        LinkedListNode head = n;

        for (int i = 0; i < padding; i++) {
            head = insertBefore(n, 0);
        }

        return head;
    }

    private LinkedListNode insertBefore(LinkedListNode list, int data) {
        LinkedListNode node = new LinkedListNode(data);

        if (list != null) {
            node.next = list;
        }

        return node;
    }

    private int length(LinkedListNode node) {
        int count = 0;
        LinkedListNode current = node;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
}
