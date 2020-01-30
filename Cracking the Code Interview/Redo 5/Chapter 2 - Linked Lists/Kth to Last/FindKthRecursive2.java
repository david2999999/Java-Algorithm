public class FindKthRecursive {
    private static class Index {
        public int value = 0;
    }

    public LinkedListNode findKthToLast(LinkedListNode head, int k) {
        Index index = new Index();
        return findKthToLast(head, k, index);
    }

    public LinkedListNode findKthToLast(LinkedListNode current, int k, Index index) {
        if (current == null) return null;

        LinkedListNode node = findKthToLast(current.next, k, index);
        index.value += 1;

        if (index.value == k) {
            return current;
        }

        return node;
    }
}