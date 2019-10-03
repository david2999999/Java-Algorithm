package TreesAndGraph.CommonAncestor;

import CodeLibrary.TreeNode;

public class Solution3 {
    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        }

        return ancestorHelper(root, p, q);
    }

    private TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        boolean pIsOnLeft = covers(root.left, p);
        boolean qIsOnLeft = covers(root.left, q);

        if (pIsOnLeft != qIsOnLeft) {
            return root;
        }
        TreeNode childSide = qIsOnLeft ? root.left : root.right;
        return ancestorHelper(childSide, p, q);
    }

    private boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }
}
