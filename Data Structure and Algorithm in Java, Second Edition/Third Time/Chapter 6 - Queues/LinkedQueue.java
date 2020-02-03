public class LinkedQueue<E> implements Queue<E> {
    private static class Node<E> {
        public E element;
        public Node prev;
        public Node next;

        public Node() {
            this.prev = this.next = this;
        }

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head = new Node<>();
    private int size = 0;

    public void add(E element) {
        Node<E> newNode = new Node<>(element, head.prev, head);
        head.prev.next = newNode;
        head.prev = newNode;
        size++;
    }

    public E element() {
        if (isEmpty()) throw new EmptyStackException();
        return head.next.element;
    }

    public E remove() {
        if (isEmpty()) throw new EmptyStackException();

        E element = head.next.element;
        head.next = head.next.next;
        head.next.prev = head;
        --size;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}