package Redo.LinkedList;

import CodeLibrary.LinkedListNode;

public class FindSumOfLists {
    private LinkedListNode findSum(LinkedListNode num1, LinkedListNode num2, int carry) {
        if (num1 == null && num2 == null && carry == 0) return null;

        LinkedListNode result = new LinkedListNode();

        int value = carry;

        if (num1 != null) {
            value += num1.data;
        }

        if (num2 != null) {
            value += num2.data;
        }

        result.data = value % 10;

        if (num1 != null || num2 != null) {
            LinkedListNode more = findSum(
                    num1 == null ? null : num1.next,
                    num2 == null ? null : num2.next,
                    value > 0 ? 1 : 0
            );
            result.setNext(more);
        }

        return result;
    }
}
