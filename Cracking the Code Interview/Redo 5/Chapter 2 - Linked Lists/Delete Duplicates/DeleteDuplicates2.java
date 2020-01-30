public class DeleteDuplicates2 {
    public void deleteDups(LinkedListNode head) {
        LinkedListNode current = head;
        LinkedListNode runner = null;

        while (current != null) {
             runner = current;

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

// This code runs in O ( 1) space, but O ( N2) time.