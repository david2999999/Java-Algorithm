public class ArrayQueue<E> implements Queue<E> {
    private E[] elements;
    private int front;
    private int back;
    private static final int INITIAL_CAPACITY = 4;

    public ArrayQueue() {
        this(INITIAL_CAPACITY);
    }

    public ArrayQueue(int initialCapacity) {
        this.elements = (E[]) new Object[initialCapacity];
    }

    public void add(E element) {
        if (size() == elements.length) resize();

        elements[back] = element;
        if (back < elements.length - 1) {
            back++;
        } else {
            back = 0;
        }
    }

    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return elements[front];
    }

    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E data = elements[front];
        elements[front] = null;
        ++front;

        if (front == back) {
            front = 0;
            back = 0;
        }

        if (front == elements.length) {
            front = 0;
        }

        return data;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void resize() {
        int size = size();
        int len = elements.length;
        assert size == len;

        Object[] newArray = new Object[2 * len];
        System.arraycopy(elements, front, newArray, 0, len - front);
        System.arraycopy(elements, 0, newArray, len - front, back);
        elements = (E[]) newArray;
        front = 0;
        back = size;
    }

    public int size() {
        if (front <= back) {
            return back - front;
        } else {
            return back - front + elements.length;
        }
    }
}