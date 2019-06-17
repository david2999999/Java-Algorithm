public class MyLinkedList<E> implements List<E> {
    private int size; // keeps track of the number of elements
    private Node head; // reference to the first node

    private class Node {
        public E data;
        public Node next;
        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public boolean add(E element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node node = head;
            // loop until the last node
            for ( ; node.next != null; node = node.next) {}
            node.next = new Node(element);
        }
        size++;
        return true;
    }
}