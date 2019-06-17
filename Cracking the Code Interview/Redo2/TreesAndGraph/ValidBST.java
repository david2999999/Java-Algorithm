package TreesAndGraph;

import CodeLibrary.TreeNode;

// implement a function to check if a binary tree is a binary search tree
// in order to be a binary search tree, left node <= center node < right node
public class ValidBST {
    // this example will use in order traveral, and save each node into an array
    // then we check if the array is in ascending order
    private int index = 0;  // counter for the array

    public boolean checkBST(TreeNode root) {
        int[] array = new int[root.size()]; // creating an array of size to the number of nodes in the tree
        copyBST(root, array);   // copying all the nodes from the tree into the array, in order traversal

        // checking if the array is in ascending order
        for (int i = 1; i < array.length; i++) {
            // the next element is lower than the previous item, not ascending, return false
            if (array[i] <= array[i - 1]) return false;
        }

        return true;    // the array is in ascending order, it is a binary search tree
    }

    // copy the all the nodes into the array
    // in order traversal, left node then center node then right node
    private void copyBST(TreeNode root, int[] array) {
        if (root == null) return;   // base case, traversed to below the leaves on the tree

        copyBST(root.left, array);   // copy the left node into the array
        array[index] = root.data;    // copy the current node into the array
        index++;        // increment the index for the array
        copyBST(root.right, array); // copy the right node into the array
    }
}
