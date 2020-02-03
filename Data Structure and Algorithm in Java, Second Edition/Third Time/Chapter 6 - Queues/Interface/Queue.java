public interface Queue<E> {
    public void add(E e);
    public E element();
    public E remove();
    public boolean isEmpty();
    public int size();
}