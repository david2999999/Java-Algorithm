package LinkedList;

public class FindingKthFromLastElement {
    public static void main(String[] args) {

    }

    public static int printKthToLast(LinkedListNode head, int k) {
        if (head == null) return 0;

        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th element from the end of the linked list is " + head.data);
        }

        return index;
    }
}
