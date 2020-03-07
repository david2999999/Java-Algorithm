public class DoublyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> {
        T data;
        Node<T> prev, next;

        public Node (T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public void clear() {
        Node<T> current = head;

        while (current != null) {
            Node<T> next = current.next;
            current.prev = current.next = null;
            current.data = null;
            current = next;
        }

        head = tail = current = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T element) {
        addLast(element);
    }

    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<T>(element, null, null);
        } else {
            head.prev = new Node<T>(element, null, head);
            head = head.prev;
        }

        size++;
    }

    public void addLast(T element) {
        if (isEmpty()) {
            head = tail = new Node<T>(element, null, null);
        } else {
            tail.next = new Node<T>(element, tail, null);
            tail = tail.next;
        }

        size++;
    }
}







