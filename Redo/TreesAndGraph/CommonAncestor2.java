package Redo.TreesAndGraph;

import CodeLibrary.TreeNode;

public class CommonAncestor2 {
    private TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!cover(root, p) || !cover(root, q)) {
            return null;
        } else if (cover(p, q)) {
            return p;
        } else if (cover(q, p)) {
            return q;
        }

        TreeNode sibling = findSibling(p);
        TreeNode parent = p.parent;

        while (!cover(sibling, q)) {
            sibling = findSibling(parent);
            parent = parent.parent;
        }

        return parent;
    }

    private boolean cover(TreeNode root, TreeNode n) {
        if (root == null) return false;
        if (root == n) return true;

        return cover(root.left, n) || cover(root.right, n);
    }

    private TreeNode findSibling(TreeNode node) {
        if (node == null || node.parent == null) return null;

        TreeNode parent = node.parent;

        return parent.left == node ? parent.right : parent.left;
    }
}
