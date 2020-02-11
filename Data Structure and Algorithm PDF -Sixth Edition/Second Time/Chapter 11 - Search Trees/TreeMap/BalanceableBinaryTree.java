public class BalanceableBinaryTree<K, V>
        extends LinkedBinaryTree<Entry<K, V>> {

    protected static class BSTNode<E> extends Node<E> {
        int aux = 0;

        public BSTNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
            super(e, parent, left, right);
        }

        public int getAux() {
            return aux;
        }

        public void setAux(int value) {
            aux = value;
        }
    }
}