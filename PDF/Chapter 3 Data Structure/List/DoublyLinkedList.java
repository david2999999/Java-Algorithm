public class DoublyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        
        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
    }
    
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
    
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    
    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }
    
    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }
    
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }
    
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }
    
    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }
    
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }
}