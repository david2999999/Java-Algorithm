public class ArrayStack<E> implements Stack<E> {
    private E[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 100;

    public ArrayStack() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
    }

    public ArrayStack(int capacity) {
        elements = (E[]) new Object(capacity);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E element = elements[--this.size];
        element[this.size] = null;
        return element;
    }

    public void push(E element) {
        if (this.size == elements.length) {
            resize();
        }

        elements[size++] = element;
    }

    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return elements[size - 1];
    }

    public int size() {
        return size;
    }

    private void resize() {
        assert size == elements.length;
        Object[] a = new Object[2 * size];
        System.arraycopy(elements, 0, a, 0, size);
        elements = (E[]) a;
    }
}