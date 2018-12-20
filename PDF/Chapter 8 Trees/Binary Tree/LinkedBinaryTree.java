public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
        
        public E getElement() {
            return element;
        }
        
        public Node<E> getParent() {
            return parent;
        }
        
        public Node<E> getLeft() {
            return left;
        }
        
        public Node<E> getRight() {
            return right;
        }
        
        public void setElement(E e) {
            element = e;
        }
        
        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }
        
        public void setLeft(Node<E> leftChild) {
            left = leftChild;
        }
        
        public void setRight(Node<E> rightChild) {
            right = rightChild;
        }
    }
    
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }
    
    
    protected Node<E> root = null;
    private int size = 0;
    
    public LinkedBinaryTree() {}
    
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) 
            throw new IllegalArgumentException("Not valid position type");
            
        Node<E> node = (Node<E>) p;
        if (node.getParent() == node) 
            throw new IllegalArgumentException("p is no longer in the tree");
        
        return node;
    }
    
    public int size() {
        return size;
    }
    
    public Position<E> root() {
        return root;
    }
    
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }
    
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }
    
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }


}