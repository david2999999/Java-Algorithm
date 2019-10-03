package CodeLibrary;

// Custom implementation of Node for LinkedList
public class LinkedListNode {
    public LinkedListNode next, prev, last;
    public int data;

    // Alt + Insert shortcut for IntelIj
    public LinkedListNode(int data, LinkedListNode next, LinkedListNode prev) {
        this.next = next;
        this.prev = prev;
        this.data = data;
    }

    public LinkedListNode(int data) {
        this.data = data;
    }

    public LinkedListNode() {
    }

    // setting the next node
    public void setNext(LinkedListNode n) {
        next = n;
        if (this == last) {
            last = n;
        }

        if (n != null && n.prev != this) {
            n.setPrevious(this);
        }
    }

    // setting the previous node
    private void setPrevious(LinkedListNode p) {
        prev = p;
        if (p != null && p.next != this) {
            p.setNext(this);
        }
    }

    public LinkedListNode clone() {
        LinkedListNode next2 = null;
        if (next != null) {
            next2 = next.clone();
        }

        LinkedListNode head2 = new LinkedListNode(data, next2, null);
        return head2;
    }
}











