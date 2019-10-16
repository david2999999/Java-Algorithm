public class Traversal {
    private void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            visit(root);
            inOrderTraversal(root.right);
        }
    }
}