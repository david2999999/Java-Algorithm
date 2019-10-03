package TreesAndGraph;

import CodeLibrary.TreeNode;

// write an algorithm to find the next node for an "in order traversal", given a node in a binary search tree
// assuming the node has access to its parent
public class SuccessorInOrderTraversal {
    // if the node has a right child, we have to find the left most element on the right subtree
    // if the node does not have a right child, we have to go up the binary search tree
    // to be on the left side instead on the right side

    public TreeNode inorderSucc(TreeNode n) {
        if (n == null) return null; // no node to be found

        // there is a right child, we have to find the leftmost element of the right subtree
        if (n.right != null) {
            return leftMostChild(n.right);
        } else {
            TreeNode q = n; // current node
            TreeNode x = q.parent;  // parent of the current node

            // go up until we are on the left instead of right
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }

            return x;   // found the next node
        }
    }

    private TreeNode leftMostChild(TreeNode n) {
        if (n == null) {
            return null;
        }

        while (n.left != null) {    // if the node has a left child
            n = n.left; // traverse down the tree
        }

        return n;   // found the leftmost node
    }
}
