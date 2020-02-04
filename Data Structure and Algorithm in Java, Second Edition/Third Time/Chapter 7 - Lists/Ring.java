public class Ring<E> extends AbstractList<E> implements List<E> {
    private Node<E> end;
    private int size;

    public boolean add(E element) {
        if (size == 0) {
            end = new Node<>(element, null);
            end.next = end;
        } else {
            Node<E> newNode = new Node<>(element, end.next);
            end.next = newNode;
            end = newNode;
        }

        ++size;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> p = end.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.element;
    }

    public Iterator<E> iterator() {
        return new RingIterator();
    }

    public String toString() {
        if (isEmpty()) return "[]";

        Node<E> p = end.next;
        StringBuilder sb = new StringBuilder();
        sb.append("["); sb.append(p.element);

        while (p != end) {
            p = p.next;
            sb.append(", " + p.element);
        }

        sb.append("]");
        return sb.toString();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}