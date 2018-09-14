package Redo.TreesAndGraph;

import CodeLibrary.TreeNode;

public class SuccessorInTree {
    public TreeNode findNext(TreeNode node) {
        if (node == null) return null;

        if (node.right != null) {
            return leftMostNode(node.right);
        } else {
            TreeNode n = node;
            TreeNode p = n.parent;

            while ( p != null && p.left != n) {
                n = p;
                p = p.parent;
            }

            return p;
        }
    }

    public TreeNode leftMostNode(TreeNode node) {
        if (node == null) return null;

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}
