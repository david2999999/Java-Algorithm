package Redo.LinkedList;

import CodeLibrary.LinkedListNode;

public class FindIntersection {
    private LinkedListNode getIntersection(LinkedListNode node1, LinkedListNode node2) {
        if (node1 == null || node2 == null) return null;

        Result result1 = getTailandLength(node1);
        Result result2 = getTailandLength(node2);

        if (result1.tail != result2.tail) return null;

        LinkedListNode shorter = result1.length < result2.length ? node1 : node2;
        LinkedListNode longer = result1.length < result2.length ? node2 : node1;

        longer = getKthNode(longer, Math.abs(result1.length - result2.length));

        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer;
    }

    private LinkedListNode getKthNode(LinkedListNode longer, int k) {
        if (longer == null) return null;

        LinkedListNode current = longer;

        while (current != null && k > 0) {
            current = current.next;
            k--;
        }

        return current;
    }

    public Result getTailandLength(LinkedListNode node) {
        if (node == null) return null;
        int size = 1;
        LinkedListNode current = node;

        while (current.next != null) {
            size++;
            current = current.next;
        }

        return new Result(current, size);
    }

    private class Result {
        public LinkedListNode tail;
        public int length;

        public Result(LinkedListNode tail, int length) {
            this.tail = tail;
            this.length = length;
        }
    }
}
