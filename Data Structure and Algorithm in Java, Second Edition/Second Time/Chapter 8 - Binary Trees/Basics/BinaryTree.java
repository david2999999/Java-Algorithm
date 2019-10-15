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

    public Node findImproved(int key) {
        Node current = root;

        while (current != null) {
            if (current.data == key) {
                return current;
            } else if (current.data < key) {
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
        }

        return null;
    }

    public void insert(int key) {

    }

    public void delete(int key) {

    }
}