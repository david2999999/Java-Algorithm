package TreesAndGraph;

import CodeLibrary.TreeNode;

// given a sorted (increasing order) array with unique integer elements
// write an algorithm to create a binary search tree with minimal height
public class MinimalTree {
    // to generate the binary search tree with the least height, we need the root to be the middle element
    // of the array. This is because half of the elements are less than that middle node, and half of
    // the elements are greater than that middle node

    // 1) insert into the tree the middle element of the array
    // 2) insert into the left subtree the left subarray elements
    // 3) insert into the right subtree the right subarray elements
    // 4) recurse

    public TreeNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    private TreeNode createMinimalBST(int[] arr, int start, int end) {
        if (end < start) {  // we have finished creating the tree
            return null;
        }

        int mid = (start + end) / 2;    // find the middle index of the array / subarray
        TreeNode n = new TreeNode(arr[mid]);    // make the middle value from the array into treeNode
        n.left = createMinimalBST(arr, start, mid - 1); // generate left subtree
        n.right = createMinimalBST(arr, mid + 1, end);  // generate right tree

        return n;   // return the root/parent of tree/subtree
    }
}
















