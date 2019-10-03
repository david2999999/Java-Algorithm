package TreesAndGraph.CheckBalanced;

import CodeLibrary.TreeNode;

public class Solution1 {
    private int getHeight(TreeNode root) {
        if (root == null) return -1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
}
