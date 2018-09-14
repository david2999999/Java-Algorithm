package Redo.TreesAndGraph;

import CodeLibrary.TreeNode;

public class CheckBalanceTree {
    private int getHeight(TreeNode node) {
        if (node == null) return -1;

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private boolean isBalanced(TreeNode node) {
        if (node == null) return true;

        int heightDiff = getHeight(node);

        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(node.left) && isBalanced(node.right);
        }
    }
}
