package Redo2.LinkedList;

public class Node {
    Node next = null;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }

        n.next = end;
    }
}
