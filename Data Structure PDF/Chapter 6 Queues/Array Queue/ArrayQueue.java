 public class ArrayQueue<E> implements Queue<E> {
     private E[] elements;
     private int front;
     private int back;
     private static final int INITIAL_CAPACITY = 4;
    
     public ArrayQueue() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
     }
    
     public ArrayQueue(int capacity) {
        elements = (E[]) new Object[capacity];
     }
    
     public void add(E element) {
         if (size() == elements.length - 1) {
            resize();
         }
         
         elements[back] = element;
         if (back < elements.length - 1) {
            ++back;
         } else {
            back = 0; //wrap
         }
     }
    
     public E element() {
         if (size() == 0) {
            throw new java.util.NoSuchElementException();
         }
         return elements[front];
     }
    
     public boolean isEmpty() {
        return (size() == 0);
     }
    
     public E remove() {
         if (size() == 0) {
            throw new java.util.NoSuchElementException();
         }
         
         E element = elements[front];
         elements[front] = null;
         ++front;
         if (front == back) { // queue is empty
            front = back = 0;
         }
         if (front == elements.length) { // wrap
            front = 0;
         }
         return element;
     }
    
     public int size() {
         if (front <= back) {
            return back - front;
         } else {
            return back - front + elements.length;
         }
     }
    
     private void resize() {
         int size = size();
         int len = elements.length;
         assert size == len;
         Object[] a = new Object[2*len];
         System.arraycopy(elements, front, a, 0, len - front);
         System.arraycopy(elements, 0, a, len - front, back);
         elements = (E[])a;
         front = 0;
         back = size;
     }
 }
 