public class LinkedQueue<E> implements Queue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E dequeue() {
        list.removeFirst();
    }

    public E first() {
        return list.first();
    }
}