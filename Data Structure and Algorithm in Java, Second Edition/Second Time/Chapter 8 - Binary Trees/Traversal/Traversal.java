public class Traversal {
    private void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            visit(root);
            inOrderTraversal(root.right);
        }
    }

    private void preOrderTraversal(Node root) {
        if (root != null) {
            visit(root);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
}