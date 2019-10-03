package LinkedList;

import CodeLibrary.LinkedListNode;

// find the Kth element from the end of a linkedlist
public class KthElementFromLast2 {
    // this example will be using the iterative approach
    // we need 2 pointers, p1 and p2

    // p1 needs to move forward Kth times
    // then p2 will move forward until p1 hits the end of the list

    public LinkedListNode nthToLast(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        // moving p1 forward k times
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;    // index out of bound
            p1 = p1.next;
        }

        while (p1 != null) {    // while p1 has not hit the end of the list
            p1 = p1.next;
            p2 = p2.next;
        }

        // p2 has reached Kth from the end of the list
        return p2;
    }
}
