public class FindKthRecursive {
    public int findKthToLast(LinkedListNode head, int k) {
        if (head == null) return 0;

        int index = findKthToLast(head.next, k) + 1;

        if (index == k) {
            System.out.println("Found element " + head.data);
        }

        return index;
    }
}