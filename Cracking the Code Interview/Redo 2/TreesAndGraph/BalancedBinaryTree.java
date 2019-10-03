package TreesAndGraph;

import CodeLibrary.TreeNode;

// implement a function to check if a binary tree is balanced
// a binary tree is balanced when the height of two subtrees of any node never differ by more than one
public class BalancedBinaryTree {
    // we have to check the height of each left sub tree
    // with the height of the right subtree and make sure the height of each tree don't differ by more than one

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;  // the MIN_VALUE will be our error code if the height
                                                        // differs by more than 1
    }

    private int checkHeight(TreeNode root) {
        if (root == null) return -1;    // found the base case, this is at the lowest part of the binary tree

        int leftHeight = checkHeight(root.left);    // check height of the left child
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;  // ERROR, NOT A BALANCED TREE

        int rightHeight = checkHeight(root.right);  // check height of the right child
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; //  ERROR, NOT A BALANCED TREE

        int heightDiff = leftHeight - rightHeight;  // checking the difference in height of each subtree
        if (Math.abs(heightDiff) > 1) { // not a balanced tree
            return Integer.MIN_VALUE;   // RETURN ERROR CODE
        } else {
            return Math.max(leftHeight, rightHeight) + 1;   // return the height + 1
                                                            // the + 1 will go up one level of the binary tree
        }
    }
}













