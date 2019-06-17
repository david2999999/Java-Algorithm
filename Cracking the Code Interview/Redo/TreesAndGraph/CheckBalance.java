package Redo.TreesAndGraph;

import CodeLibrary.TreeNode;

public class CheckBalance {
    private int checkHeight(TreeNode root) {
        if (root == null) return -1;
        return Math.max(checkHeight(root.left), checkHeight(root.right)) + 1;
    }

    private boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int height = Math.abs(checkHeight(root.left) - checkHeight(root.right));

        if (height > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
}
