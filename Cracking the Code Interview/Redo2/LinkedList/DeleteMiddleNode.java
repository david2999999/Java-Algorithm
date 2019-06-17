package LinkedList;

import CodeLibrary.LinkedListNode;

// delete the middle node in a singly LinkedList
// for examples a -> b -> c
// delete b, when we have only access to b
public class DeleteMiddleNode {

    public boolean deleteNode(LinkedListNode n) {
        // if there is no current or next node
        if (n == null || n.next == null) return false;

        LinkedListNode next = n.next;   // if n = b, then next = c
        n.data = next.data; // copy the data from c in b
                            // list looks like this now a -> c -> c -> null
        n.next = next.next; // remove the last c node. list looks like = a -> c -> null

        return true;
    }
}
