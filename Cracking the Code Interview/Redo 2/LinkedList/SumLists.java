package LinkedList;

import CodeLibrary.LinkedListNode;

// two numbers are represented by a linked list
// each of the nodes represent a single digit of the number
// the digits are stored in reverse order, the 1's digit is at the head of the list
// write a method to find the sum and return the sum as a linked list
public class SumLists {
    // need to use recursion

    public LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        // finished calculating the sum
        if (l1 == null && l2 == null && carry == 0) return null;

        LinkedListNode result = new LinkedListNode();
        int value = carry;  // the carry will be initially 0

        if (l1 != null) {
            value += l1.data;
        }

        if (l2 != null) {
            value += l2.data;
        }

        result.data = value % 10;   // second digit of number

        if (l1 != null || l2 != null) {
            // calculating the next node
            LinkedListNode more = addLists(l1 != null ? null : l1.next, // checking if the first number
                                                                        // has more values
                                            l2 != null ? null : l2.next, // checking for next values of l2
                                            value >= 10 ? 1 : 0);   // if the value is greater than 10
                                                                    // we have a carry of 1

            result.setNext(more);   // set the next node to the current sum
        }

        return result;
    }
}


















