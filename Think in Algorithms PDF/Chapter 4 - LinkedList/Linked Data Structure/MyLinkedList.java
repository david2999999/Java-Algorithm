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
    
    public int indexOf(Object target) {
        Node node = head;
        for (int i=0; i<size; i++) {
            if (equals(target, node.data)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }
    
    public void add(int index, E element) {
        if (index == 0) {
            head = new Node(element, head);
        } else {
            Node node = getNode(index-1);
            node.next = new Node(element, node.next);
        }
        size++;
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