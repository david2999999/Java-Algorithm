public class Sucessor {
    public TreeNode inorderSucc(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return findLeftMostNode(node.right);
        } else {
            TreeNode current = node;
            TreeNode parent = current.parent;

            while (parent != null && parent.right != current) {
                current = parent;
                parent = parent.parent;
            }

            return parent;
        }
    }

    private TreeNode findLeftMostNode(TreeNode node) {
        if (node == null) {
            return null;
        }

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}