package Redo.TreesAndGraph;

import CodeLibrary.TreeNode;

public class CheckBalanceOptimized {
    private int checkheight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkheight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkheight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public boolean checkBalance(TreeNode node) {
        return checkheight(node) != Integer.MIN_VALUE;
    }
}
