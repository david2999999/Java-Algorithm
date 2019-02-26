 public interface Queue<E> {
     public void add(E element);
     public E element();
     public boolean isEmpty();
     public E remove();
     public int size();
 }