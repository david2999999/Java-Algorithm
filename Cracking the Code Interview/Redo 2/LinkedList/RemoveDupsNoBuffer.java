package LinkedList;

import CodeLibrary.LinkedListNode;

// write code to remove duplicates from a LinkedList
// but without using a buffer such as a Hashset
public class RemoveDupsNoBuffer {
    // since we are not using a buffer
    // we need 2 pointers, one for current node and another one as a runner

    public void deleteDups(LinkedListNode head) {
        LinkedListNode current = head;

        while (current != null) {
            LinkedListNode runner = current;    // this node will move forward
                                                // and detect any duplicates
            while (runner.next != null) {
                if (runner.next.data == current.data) { // there is a duplicate in the front of the list
                    runner.next = runner.next.next; // skipping over the duplicate element
                } else {
                    runner = runner.next;   // no duplicates -> continue moving forward
                }
            }

            current = current.next; // moving the current pointer forward after the runner finishes
        }
    }

    // Since we are looping over the linkedlist with 2 while loops. This will take O(n^2) time
    // but will use O(1) space, because we did not use a buffer.
}
