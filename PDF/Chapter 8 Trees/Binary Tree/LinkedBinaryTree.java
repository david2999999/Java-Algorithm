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
    
}