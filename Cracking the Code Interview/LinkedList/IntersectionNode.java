package LinkedList;

public class IntersectionNode {
    public static void main(String[] args) {

    }

    private static LinkedListNode intersection(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        if (result1.tail != result2.tail) return null;

        LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
        LinkedListNode longer = result1.size < result2.size ? list2 : list1;

        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        // return either one, they are both equal
        return longer;
    }

    private static LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;

        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }

        return current;
    }

    private static Result getTailAndSize(LinkedListNode list) {
        if (list == null) return null;

        int size = 1;
        LinkedListNode current = list;

        while (current.next != null) {
            size++;
            current = current.next;
        }

        return new Result(current, size);
    }


    private static class Result {
        public LinkedListNode tail;
        public int size;

        public Result(LinkedListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }
}
