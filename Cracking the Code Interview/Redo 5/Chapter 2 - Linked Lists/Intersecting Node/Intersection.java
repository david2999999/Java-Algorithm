public class Intersection {
    private static class Result {
        public int size;
        public LinkedListNode tail;

        public Result(int size, LinkedListNode tail) {
            this.size = size;
            this.tail = tail;
        }
    }

    public LinkedListNode findIntersection(LinkedListNode node1, LinkedListNode node2) {
        if (node1 == null || node2 == null) return null;

        Result result1 = getTailAndSize(node1);
        Result result2 = getTailAndSize(node2);

        if (result1.tail != result2.tail) return null;

        LinkedListNode shorter = result1.size < result2.size ? node1 : node2;
        LinkedListNode longer = result1.size < result2.size ? node2 : node1;

        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return shorter;
    }

    private LinkedListNode getKthNode(LinkedListNode head, int step) {
        LinkedListNode current = head;

        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }

        return current;
    }

    private Result getTailAndSize(LinkedListNode node) {
        if (node == null) return null;

        int length = 1;
        LinkedListNode current = node;

        while (current.next != null) {
            length++;
            current = current.next;
        }

        return new Result(length, current);
    }
}