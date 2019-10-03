package TreesAndGraph;

import CodeLibrary.TreeNode;

// implement a function to check if a binary tree is a binary search tree
// in order to be a binary search tree, left node <= center node < right node
public class ValidBST2 {
    // in this example, we will not use an array to verify that the binary tree is a valid
    // binary search tree, we will compare values as we go through the tree
    // we will use in order traversal

    // we want an Integer type because we want the value to be able to contain null
    private Integer last_printed = null;

    public boolean checkBST(TreeNode n) {
        // we need an integer to be our last value to compare with the current value
        if (n == null) return true; // base case, reached the bottom on the tree, return true

        // in order traversal . left node, then parent node, then right node
        if (!checkBST(n.left)) return false; // recurse the left side of the tree first

        // if there is a last printed value, note: this last_printed value may be the left node or the right node
        // if the last printed node is greater than the current node, then it is not a BST, return false
        if (last_printed != null && n.data <= last_printed) {
            return false;
        }

        last_printed = n.data;  // saving the previous value

        if (!checkBST(n.right)) return false;   // recurse to the right side of the tree

        return true;    // successful, fits the BST rule
    }
}
