package LinkedList;

import CodeLibrary.LinkedListNode;

// given a circular linked list, create a function that detects the beginning of the loop
//  a -> b -> c -> d -> e -> c [the same c as before]
// c is the beginning of the loop
public class LoopDetection {
    // we need a slow pointer and a fast pointer
    // the slow pointer will move one step at a time
    // the fast pointer will move two step at a time
    // when the two pointers collide, they are both inside the loop

    // the slow node will be at the beginning of the loop in k steps
    // the fast node will be inside loop by then
    // the distance between the two nodes is LOOP_SIZE - k

    // if the two nodes continue to move, they will meet after LOOP_SIZE - k turns
    // both of the nodes will be k steps from the beginning of the loop
    // the head of the linked list is also k steps from the beginning of the loop

    public LinkedListNode findBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // 1 step at a time
            fast = fast.next.next;  // 2 steps at a time

            if (slow == fast) { // collision inside the loop
                break;
            }
        }

        // there is no loop if there are null values for the fast pointer
        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;    // move the slow node to the beginning of the linked list
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;    // at the point, both nodes will be at the beginning of the node
    }


}



















