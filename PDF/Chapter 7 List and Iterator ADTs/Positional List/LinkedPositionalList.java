public class LinkedPositionalList implements PositionalList<E> {
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        
        public E getElement() throws IllegalStateException {
            if (next == null)
                throw new IllegalStateException("Position is not longer valid");
            return element;
        }
        
        public E getElement() { return element; }
        public void setElement(E e) { element = e; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
    }
    
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    
    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
    
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p;
        if (node.getNext() == null)
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }
    
    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer)
            return null;
        return node;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public Position<E> first() {
        return position(header.getNext());
    }
    
    public Position<E> last() {
        return position(trailer.getPrev());
    }
    
    public Position<E> before(Position<E> p) throws IllegalStateException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }
    
    public Position<E> after(Position<E> p) throws IllegalStateException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }
    
    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }
    
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }
    
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }
    
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }
    
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }
    
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }
}