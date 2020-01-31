public interface Stack<E> {
    public boolean isEmpty();
    public E pop();
    public void push(E element);
    public E peek();
    public int size();
}