package Redo.LinkedList;

import CodeLibrary.LinkedListNode;

public class FindSumOf2ListForward {

    private class PartialSum {
        public LinkedListNode sum = null;
        public int carry = 0;
    }

    private LinkedListNode sumList(LinkedListNode num1, LinkedListNode num2) {
        int l1 = length(num1);
        int l2 = length(num2);

        if (l1 < l2) {
            num1 = padList(num1, l2 - l1);
        } else {
            num2 = padList(num2, l1 - l2);
        }

        PartialSum partialSum = sumListHelper(num1, num2);

        if (partialSum.carry != 0) {
            LinkedListNode sum = insertBefore(partialSum.sum, partialSum.carry);
            return sum;
        } else {
            return partialSum.sum;
        }
    }

    private PartialSum sumListHelper(LinkedListNode num1, LinkedListNode num2) {
        if (num1 == null && num2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }

        PartialSum sum = sumListHelper(num1.next, num2.next);

        int val = num1.data + num2.data + sum.carry;

        LinkedListNode result = insertBefore(sum.sum, val % 10);

        sum.sum = result;
        sum.carry = val > 10 ? 1 : 0;

        return sum;
    }

    private LinkedListNode padList(LinkedListNode head, int num) {
        if (head == null) return null;
        LinkedListNode node = head;

        for (int i = 0; i < num; i++) {
            node = insertBefore(node, 0);
        }

        return node;
    }

    private LinkedListNode insertBefore(LinkedListNode node, int data) {
        LinkedListNode newNode = new LinkedListNode(data);

        if (node != null) {
            newNode.next = node;
        }

        return newNode;
    }

    private int length(LinkedListNode node) {
        int sum = 0;
        LinkedListNode current = node;

        while (current != null) {
            sum++;
            current = current.next;
        }

        return sum;
    }
}
