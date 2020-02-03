public interface Queue<E> {
    public void enqueue(E e);
    public E dequeue();
    public E first();
    public boolean isEmpty();
    public int size();
}