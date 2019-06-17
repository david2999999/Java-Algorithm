package Redo.TreesAndGraph;

import CodeLibrary.TreeNode;

public class CommonAncestorWithoutLinkToParent {
    private TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!cover(root, p) || !cover(root, q)) return null;

        return ancestorHelper(root, p, q);
    }

    private TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q) return root;

        boolean pOnLeft = cover(root.left, p);
        boolean qOnLeft = cover(root.right, q);

        if (pOnLeft != qOnLeft) {
            return root;
        }

        TreeNode childSide = pOnLeft ? root.left : root.right;

        return ancestorHelper(childSide, p, q);
    }

    private boolean cover(TreeNode root, TreeNode n) {
        if (root == null) return false;
        if (root == n) return true;

        return cover(root.left, n) || cover(root.right, n);
    }
}
