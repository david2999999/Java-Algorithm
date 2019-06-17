package Redo.TreesAndGraph;

import CodeLibrary.TreeNode;

public class CommonAncestor {
    private TreeNode findAncestor(TreeNode p, TreeNode q) {
        int depth = depth(p) - depth(q);
        TreeNode first = depth > 0 ? q : p; // shallower
        TreeNode second = depth > 0 ? p : q; // deeper

        second = goUpBy(second, Math.abs(depth));

        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }

        return first == null || second == null ? null : first;

    }

    private TreeNode goUpBy(TreeNode node, int level) {
        while (node != null && level > 0) {
            node = node.parent;
            level--;
        }

        return node;
    }

    private int depth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }

        return depth;
    }
}
