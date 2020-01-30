public class CircularlyLinkedList<E> {
    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {}

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    public void addFirst(E e) {
        if (isEmpty()) {
            tail == new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<E>(e, tail.getNext());
            tail.setNext(newest);
        }

        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.next();
    }

    public E removeFirst() {
        if (isEmpty()) return null;

        Node<E> head = tail.next();
        if (head == tail) {
            tail = null;
        } else {
            tail.setNext(head.next());
        }

        size--;
        return head.getElement();
    }
}








