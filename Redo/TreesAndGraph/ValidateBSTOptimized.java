package Redo.TreesAndGraph;

import CodeLibrary.TreeNode;

public class ValidateBSTOptimized {
    public boolean isBST(TreeNode node) {
        return isBST(node, null, null);
    }

    public boolean isBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.data <= min) || (max != null && node.data > max)) {
            return false;
        }

        if ((!isBST(node.left, min, node.data)) || (!isBST(node.right, node.data, max))) {
            return false;
        }

        return true;
    }
}
