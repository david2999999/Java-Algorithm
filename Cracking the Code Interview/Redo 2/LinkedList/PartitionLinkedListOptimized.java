package LinkedList;

import CodeLibrary.LinkedListNode;

// given the head of a linked list, partition the linked list around the value x
// all of the nodes that are less than x are to the left
// all of the nodes that are more than x are to the right
public class PartitionLinkedListOptimized {
    // Instead of using 4 variables to partition the list
    // this example will only use 2 nodes, the head and the tail

    public LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        // all of the nodes smaller than x will prepend to the head
        // all of the node bigger than x will be appended to the tail
        while (node != null) {
            LinkedListNode next = node.next;

            if (node.data < x) {    // data is smaller
                node.next = head;   // prepend to the head
                head = node;
            } else {                // data is bigger
                tail.next = node;   // append to tail
                tail = node;
            }
            node = next;
        }

        tail.next = null;

        return head;    // returns the new head of the linked list
    }
}









