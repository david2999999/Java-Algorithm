package LinkedList;

import CodeLibrary.LinkedListNode;

// given the head of a linked list, partition the linked list around the value x
// all of the nodes that are less than x are to the left
// all of the nodes that are more than x are to the right
public class PartitionLinkedList {

    public LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;  // the start of the list to the left of x
        LinkedListNode beforeEnd = null;    // the end of the list to the left of x
        LinkedListNode afterStart = null;   // the start of the list to the right of x
        LinkedListNode afterEnd = null;     // the end of the list to the right of x

        while (node != null) {
            LinkedListNode next = node.next;    // saving the next node
            node.next = null;   // remove the link to the next node

            if (node.data < x) {
                // insert the node to the list on the left
                if (beforeStart == null) {  // the left list is currently empty
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;  // append to the end of the left list
                    beforeEnd = node;
                }
            } else {
                // insert the node to the list on the right
                if (afterStart == null) {   // if the list on the right is empty
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;   // append to the end of the right list
                    afterEnd = node;
                }
            }
            node = next;    // continuing on with the list
        }

        if (beforeStart == null) {  // if the left list is empty
            return afterStart;  // return the start of the list on the right
        }

        beforeEnd.next = afterStart;    // append the right list to the end of the left list
        return beforeStart; // return the beginning of the left list
    }
}













