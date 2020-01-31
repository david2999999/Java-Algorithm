public class SumListForward {
    public LinkedListNode sumList(LinkedListNode node1, LinkedListNode node2) {
        return sumList(node1, node2, 0);
    }

    private LinkedListNode sumList(LinkedListNode node1, LinkedListNode node2, int carry) {
        if (node1 == null && node2 == null && carry == 0) {
            return null;
        }

        LinkedListNode result = new LinkedListNode();
        int sum = carry;

        if (node1 != null) sum += node1.data;
        if (node2 != null) sum += node2.data;

        result.data = sum % 10;

        if (node1 != null || node2 != null) {
            LinkedListNode more = sumList(node1 != null ? node1.next: null,
                    node2 != null ? node2.next: null,
                    sum > 9);

            result.setNext(more);
        }

        return result;
    }
}