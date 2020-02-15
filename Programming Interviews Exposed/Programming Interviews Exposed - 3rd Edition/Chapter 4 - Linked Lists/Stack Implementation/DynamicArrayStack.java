public class DynamicArrayStack<E> implements Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 8;

    public DynamicArrayStack() {
        this(INITIAL_CAPACITY);
    }

    public DynamicArrayStack(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elements[size - 1];
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }

        E lastElement = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return lastElement;
    }

    public void push(E value) {
        if (isFull()) {
            resize();
        }

        elements[size++] = value;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    private boolean isFull() {
        return this.size == elements.length;
    }

    private void resize() {
        if (size != elements.length) {
            throw new IllegalStateException();
        }

        int doubleSize = size * 2;
        E[] newArray = (E[]) new Object[doubleSize];

        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }

        elements = newArray;
    }
}