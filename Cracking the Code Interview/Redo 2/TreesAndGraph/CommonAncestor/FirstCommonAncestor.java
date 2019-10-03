package TreesAndGraph.CommonAncestor;

import CodeLibrary.TreeNode;

// given 2 nodes in a binary tree
// find the first common ancestor of the 2 nodes
public class FirstCommonAncestor {
    // we have to find the depth of each node
    // then move the deeper node upward to match the depth of the other node
    // then move both of the nodes upward until we find a matching ancestor

    public TreeNode commonAncestor(TreeNode p, TreeNode q) {
        int delta = depth(p) - depth(q);    // find the difference in depth
        TreeNode first = delta > 0 ? q : p; // get shallower node
        TreeNode second = delta > 0 ? p : q;    // get deeper node

        second = goUpBy(second, Math.abs(delta));   // move the deeper node upward by the difference in depth

        // while both nodes do not equal each other
        // comparison to null is to prevent null pointer exceptions
        while (first != second && first != null && second != null) {
            // move both nodes upward
            first = first.parent;
            second = second.parent;
        }

        // if 1 or both of them are null, then there is no common ancestor
        // else
        // return either of the nodes
        return first == null || second == null ? null : first;
    }

    private TreeNode goUpBy(TreeNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent; // move node upward
            delta--;    // decrement the difference in depth
        }

        return node;
    }

    // finding the depth of a node
    private int depth(TreeNode node) {
        int depth = 0;  // counter for the depth

        while (node != null) {  // move node upward until it gets to the root
            node = node.parent; // move the node upward
            depth++;
        }

        return depth;
    }
}
