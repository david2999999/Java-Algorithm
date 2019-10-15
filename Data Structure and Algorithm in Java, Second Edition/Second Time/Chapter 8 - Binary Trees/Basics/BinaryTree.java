public class BinaryTree {
    private Node root;

    public Node find(int key) {
        Node current = root;

        while (current.data != key) {
            if (key < current.data) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) return null;
        }

        return current;
    }

    public void insert(int key) {

    }

    public void delete(int key) {

    }
}