public abstract class AbstractStack<E> implements Stack<E> {
    protected int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public abstract E peek();
    public abstract E pop();
    public abstract void push();

    public int getSize() {
        return size;
    }
}