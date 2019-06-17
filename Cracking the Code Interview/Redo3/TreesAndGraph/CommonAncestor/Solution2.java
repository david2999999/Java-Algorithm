package TreesAndGraph.CommonAncestor;

import CodeLibrary.TreeNode;

public class Solution2 {
    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        } else if (covers(p, q)) {
            return p;
        } else if (covers(q, p)) {
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

    private TreeNode getSibling(TreeNode node) {
        if (node == null || node.parent == null) {
            return null;
        }

        TreeNode parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }

    private boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }
}
