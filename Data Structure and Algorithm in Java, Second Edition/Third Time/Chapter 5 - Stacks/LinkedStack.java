public class LinkedStack<E> implements Stack<E> {
    private static class Node<E> {
        public E element;
        public Node<E> next;
        public Node<E> prev;

        public Node() {
            this.prev = this.next = this;
        }

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> head = new Node<E>();
    private int size;

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return head.prev.element;
    }

    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E element = head.prev.element;
        head.prev = head.prev.prev;
        head.prev.next = head;
        return element;
    }

    public void push(E element) {
        Node<E> newNode = new Node<E>(element, head.prev, head);
        head.prev.next = newNode;
        head.prev = newNode;
        size++;
    }

    public int size() {
        return size;
    }
}