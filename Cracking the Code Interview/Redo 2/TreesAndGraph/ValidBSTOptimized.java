package TreesAndGraph;

import CodeLibrary.TreeNode;

// implement a function to check if a binary tree is a binary search tree
// in order to be a binary search tree, left node <= center node < right node
public class ValidBSTOptimized {
    // when traversing to the left, there is a minimum and maximum value
    // the min value will the the node on the left side, and the maximum value will be the parent node

    // when traversing to the right, there is also a min and max value
    // the min value will be the parent node, and the max value will be the right node

    // since left node <= center node < right node

    public boolean checkBST(TreeNode n) {
        // initially the min and max value will be null
        return checkBST(n, null, null);
    }

    private boolean checkBST(TreeNode n, Integer min, Integer max) {
        if (n == null) return true; // base case, successfully traverse to the bottom of the tree

        // checking if the current value is less than or equal to the min value, assuming no duplicates in tree
        // or if the current value is greater than the max value
        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }

        // when traversing left, we want the current data or parent node to be the max value
        // when traversing right, we want the current data or parent node to be the min value
        if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
            return false;
        }

        return true;    // successfully pass the case
    }
}














