 public class Ring<E> extends AbstractList<E> implements List<E> {
     private Node<E> end;
     private int size;
    
     public boolean add(E element) {
         if (size == 0) {
             end = new Node<E>(element, null);
             end.next = end;
         } else {
            end = end.next = new Node<E>(element, end.next);
         }
         ++size;
         return true;
     }
    
     public E get(int index) {
         if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
         }
         Node<E> p = end.next;
         for (int i=0; i<index; i++) {
            p = p.next;
         }
         
         return p.element;
    }
        
     public Iterator<E> iterator() {
         return new RingIterator();
     }
    
     public String toString() {
         Node<E> p = end.next;
         StringBuilder buf = new StringBuilder("[" + p.element);
         while (p != end) {
             p = p.next;
             buf.append(", " + p.element);
         }
         buf.append("]");
         return buf.toString();
    }
        
    public int size() {
         return size;
     }
    
     private class RingIterator implements Iterator<E> {
         private Node<E> last;
         private Node<E> preLast = end;
        
         public boolean hasNext() {
            return size > 0;
         }
        
         public E next() {
             if (last == null) {
                last = preLast.next;
             } else {
                 preLast = last;
                 last = last.next;
             }
             return last.element;
         }
        
         public void remove() {
             if (last == null) {
                throw new IllegalStateException();
             }
             if (size == 1) {
                end = preLast = null;
             } else {
                preLast.next = last.next;
             }
             
             if (last == end) {
                end = preLast;
             }
             last = null;
             --size;
         }
     }
    
     private static class Node<E> {
         E element;
         Node<E> next;
        
         Node(E element, Node<E> next) {
             this.element = element;
             this.next = next;
         }
     }
 }