public class ArrayQueue<E> implements Queue<E> {
    private static final int CAPACITY = 20;
    private int size = 0;
    private int frontIndex = 0;
    private E[] data;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void enqueue(E e) throws IllegalStateException {
        if (size == data.length) throw new IllegalStateException("Queue is full");

        int availableIndex = (frontIndex + size) % data.length;
        data[availableIndex] = e;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) return null;

        E element = data[frontIndex];
        data[frontIndex] = null;
        frontIndex = (frontIndex + 1) % data.length;
        size--;
        return element;
    }

    public E first() {
        if (isEmpty()) return null;
        return data[frontIndex];
    }
}