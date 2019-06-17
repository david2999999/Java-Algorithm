package LinkedList;

public class RemovingDuplicatesWithRunner {
    public static void main(String[] args) {

    }

    private static void deleteDups(LinkedListNode head) {
        LinkedListNode current = head;

        while (current != null) {
            LinkedListNode runner = current;

            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }
}
