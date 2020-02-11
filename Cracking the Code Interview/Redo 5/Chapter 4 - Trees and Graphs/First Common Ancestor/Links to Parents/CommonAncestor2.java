public class CommonAncestor2 {
    public TreeNode commonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (!covers(root, node1) || !covers(root, node2)) {
            return null;
        } else if (covers(node1, node2)) {
            return node1;
        } else if (covers(node2, node1)) {
            return node2;
        }

        TreeNode sibling = sibling(node1);
        TreeNode parent = node1.parent;

        while (!covers(sibling, node2)) {
            sibling = sibling(parent);
            parent = parent.parent;
        }

        return parent;
    }

    private TreeNode sibling(TreeNode node) {
        if (node == null || node.parent == null) {
            return null;
        }

        TreeNode parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }

    private boolean covers(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node) return true;

        return covers(root.left, node) || covers(root.right, node);
    }
}