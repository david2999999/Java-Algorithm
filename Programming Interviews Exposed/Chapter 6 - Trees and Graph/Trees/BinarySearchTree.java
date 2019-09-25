public class BinarySearchTree {
    public TreeNode findNode(TreeNode root, int value) {
        if (root == null) return null;

        TreeNode current = root;

        while(current != null) {
            if (current.getValue() == value) {
                return current;
            } else if (current.getValue() < value) {
                current = current.getRight();
            } else {
                current = current.getLeft();
            }
        }

        return null;
    }
}
