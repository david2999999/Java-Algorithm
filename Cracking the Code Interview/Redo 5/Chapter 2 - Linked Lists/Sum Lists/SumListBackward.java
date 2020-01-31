public class SumListBackward {
    private static class PartialSum {
        public LinkedListNode sum = null;
        public int carry = 0;

        public void insertBefore(int data) {
            LinkedListNode newNode = new LinkedListNode(data);
            if (sum != null) {
                newNode.setNext(sum);
            }
            sum = newNode;
        }

        public int setCarry(int carry) {
            this.carry = carry;
        }
    }

    public LinkedListNode sumLists(LinkedListNode node1, LinkedListNode node2) {
        int length1 = length(node1);
        int length2 = length(node2);

        if (length1 < length2) {
            node1 = padList(node1, length2 - length1);
        } else {
            node2 = padList(node2, length1 - length2);
        }

        PartialSum result = sumListsHelper(node1, node2);

        if (result.carry > 0) {
            result.insertBefore(result.carry);
        }

        return result.sum;
    }

    private PartialSum sumListsHelper(LinkedListNode node1, LinkedListNode node2) {
        if (node1 == null && node2 == null) return new PartialSum();

        PartialSum result = sumListsHelper(node1, node2);

        int sum = result.carry;
        sum += (node1.data + node2.data);

        result.insertBefore(sum % 10);
        result.setCarry(sum > 9);
        return result;
    }

    private LinkedListNode padList(LinkedListNode head, int padding) {
        LinkedListNode emptyNode = null;

        for (int i = 0; i < padding; i++) {
            emptyNode = new LinkedListNode(0);
            emptyNode.setNext(head);
            head = emptyNode;
        }

        return head;
    }

    private int length(LinkedListNode head) {
        int length = 0;
        int current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }
}