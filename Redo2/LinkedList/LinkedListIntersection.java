package LinkedList;

import CodeLibrary.LinkedListNode;

// Given two singly linked list, find the intersection of the 2 list
// return the reference (node) of the intersection if found
public class LinkedListIntersection {
    // to know if there is an intersection, both of the tails of the list should be the same
    // we also need to find the length of the lists, to determine if a linked list is longer than the other

    // for example
    // 3 -> 1 -> 5 -> 9             longer linkedlist
    //                  [
    //                      7 -> 2 -> 1     7 is the intersection
    //                  [
    //           4 -> 6             shorter linked list

    public LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null || list2 == null) return null;    // there are no lists to compare

        // the result object will have both the tail and the size of the lists
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        if (result1.tail != result2.tail) { // if they don't stop at the same tail, there is no intersection
            return null;
        }

        LinkedListNode shorter = result1.size < result2.size ? list1 : list2;   // shorter list
        LinkedListNode longer = result1.size < result2.size ? list2 : list1;    // longer list

        // move the pointer of the longer list forward to match the length of the shorter list
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        // move both pointers forward until they find the intersection
        // in which they are both equal
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;  // can return either shorter or longer, they are now equal
    }

    private LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;

        // move the node forward k times
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }

        return current;
    }

    private Result getTailAndSize(LinkedListNode list) {
        if (list == null) return null; // there is no list

        int size = 1;   // accounting for the first node
        LinkedListNode current = list;

        while (current.next != null) {  // looping through the list
            size++;
            current = current.next;
        }

        // the current will now be the tail
        // the size will be the length of the list
        return new Result(current, size);
    }
}


















