public class BalancedBinaryTree {
    public int checkHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return leftHeight;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return rightHeight;

        int heightDifference = leftHeight - rightHeight;

        if (Math.abs(heightDifference) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }
}