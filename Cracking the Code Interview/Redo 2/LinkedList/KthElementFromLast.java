package LinkedList;

import CodeLibrary.LinkedListNode;

// find the Kth element from the end of a linkedlist
public class KthElementFromLast {
    // this will be a recursive approach, but we are not returning the Kth element from last
    // just going to print the value

    public int printKthToLast(LinkedListNode head, int k) {
        if (head == null) return 0; // reached the end of the linkedlist

        // this will recursive to the end of the linkedlist
        // until it gets return a 0 when head == null
        int index = printKthToLast(head.next, k) + 1;

        if (index == k) {   // we have found the Kth element from the end of the list
            System.out.println(k + "th to last node is " + head.data);
        }

        return index;
    }

}
