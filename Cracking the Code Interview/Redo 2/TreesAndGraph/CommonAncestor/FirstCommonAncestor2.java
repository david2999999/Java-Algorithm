package TreesAndGraph.CommonAncestor;

import CodeLibrary.TreeNode;

// given 2 nodes in a binary tree
// find the first common ancestor of the 2 nodes
public class FirstCommonAncestor2 {
    // this example will use a method of checking if a node is inside a subtree
    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) {   // if the tree does not contain either p or q
            return null;    // return no common ancestor
        } else if (covers(p, q)) {   // if q is contained inside a subtree where p is the root
            return p;   // found the common ancestor
        } else if (covers(q, p)) {  // if p is contained inside a subtree where q is the root
            return q;   // found common ancestor
        }

        // moving up the tree to find the node that covers q
        TreeNode sibling = getSibling(p);
        TreeNode parent = p.parent;

        while (!covers(sibling, q)) {   // while the sibling subtree does not contain q
            sibling = getSibling(parent);   // sibling of the parent node
            parent = parent.parent; // move up the tree
        }

        return parent;  // found the root of subtree that covers q
    }

    // find the sibling of a node
    private TreeNode getSibling(TreeNode node) {
        if (node == null || node.parent == null) {  // there is no sibling
            return null;
        }

        TreeNode parent = node.parent;

        // if the node is currently at the parent's left, return the right node
        // if the node is currently at the parent's right, return the left node
        return parent.left == node ? parent.right : parent.left;
    }

    // this method checks if p in the subtree
    private boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false; // not in the subtree
        if (root == p) return true; // we have found the node in the subtree

        // traverse to both the left and the right of the subtree to find node p
        return covers(root.left, p) || covers(root.right, p);
    }
}
