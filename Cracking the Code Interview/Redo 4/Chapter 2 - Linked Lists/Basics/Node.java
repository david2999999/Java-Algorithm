public class Node {
    private Node next = null;
    int data;

    public Node(int d) {
        this.data = d;
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