public interface Stack<E> {
    public boolean isEmpty();
    public E peek();
    public E pop();
    public void push(E element);
    public int size();
}