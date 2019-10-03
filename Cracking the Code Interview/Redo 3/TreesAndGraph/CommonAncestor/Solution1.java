package TreesAndGraph.CommonAncestor;

import CodeLibrary.TreeNode;

public class Solution1 {
    public TreeNode commonAncestor(TreeNode p, TreeNode q) {
        int delta = depth(p) - depth(q);
        TreeNode first = delta > 0 ? q : p;
        TreeNode second = delta > 0 ? p : q;

        second = goUpBy(second, Math.abs(delta));

        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }

        return first == null || second == null ? null : first;
    }

    private TreeNode goUpBy(TreeNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
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
