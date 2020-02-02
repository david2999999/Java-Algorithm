public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int top = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return top + 1;
    }

    public int isEmpty() {
        return top == -1;
    }

    public void push(E e) throws IllegalStateException {
        if (size() == data.length)
            throw new IllegalStateException("Stack is full");

        data[++top] = e;
    }

    public E pop() {
        if (isEmpty()) return null;
        E result = data[top];
        data[top] = null;
        top--;
        return result;
    }

    public E peek() {
        if (isEmpty()) return null;
        return data[top];
    }
}