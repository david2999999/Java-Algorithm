package TreesAndGraphs;

public class FindingCommonAncestorTraceUpwards {
    private TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)){
            return null;
        } else if (covers(p, q)) {
            return p;
        } else if (covers(q, p)){
            return q;
        }

        TreeNode sibling = getSibling(p);
        TreeNode parent = p.parent;

        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }

        return parent;
    }

    private boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;

        return covers(root.left, p) || covers(root.right, p);
    }

    private TreeNode getSibling(TreeNode node) {
        if (node == null) return null;

        TreeNode parent = node.parent;

        return parent.left == node ? parent.right : parent.left;
    }

    private class TreeNode {
        public TreeNode parent;
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
