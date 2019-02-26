 public abstract class AbstractStack<E> implements Stack<E> {
     protected int size;
    
     public boolean isEmpty() {
        return (size == 0);
     }
    
     abstract public E peek();
    
     abstract public E pop();
    
     abstract public void push(E element);
    
     public int size() {
        return size;
     }
 }