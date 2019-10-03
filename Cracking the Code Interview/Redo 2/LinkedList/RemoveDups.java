package LinkedList;

import CodeLibrary.LinkedListNode;

import java.util.HashSet;

// write code to remove duplicates from a LinkedList
public class RemoveDups {

    public void deleteDups(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<>(); // a set to keep track of duplicate values
        LinkedListNode previous = null; // a node to keep track of the previous node

        while (n != null) { // looping through the list
            if (set.contains(n.data)) { // if the set already contains the data
                previous.next = n.next; // skipping the current node
            } else {
                set.add(n.data);    // the data is not in the set -> data added to set
                previous = n;   // keeping track of previous value
            }

            n = n.next; // continue on with the linkedlist
        }
    }
}
