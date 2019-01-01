package TreesAndGraph;

import CodeLibrary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

// given a binary tree, design an algorithm which creates a linked list of all the nodes at
// each depth or level
public class ListOfDepthsBreathFirst {
    // this example will be using breathfirst search on the binary tree
    // basically starting with the root and then go down one level at a time

    public ArrayList<LinkedList<TreeNode>> createLeveledLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> results = new ArrayList<>();    // contains all the levels of treenode

        LinkedList<TreeNode> current = new LinkedList<>();  // keeps track of a level in the binary tree

        if (root != null) {
            current.add(root);  // adding the root to the first level
        }

        // breath first starts here
        while (current.size() > 0) {
            results.add(current);   // add the previous level
            LinkedList<TreeNode> parents = current; // use the parents to iterative over all the children
            current = new LinkedList<>();   // used to keep track of the current level

            for (TreeNode parent: parents) {    // all the parent node from the level
                if (parent.left != null) {  // if a left children exist
                    current.add(parent.left);   // add the left children to the current level
                }

                if (parent.right != null) { // if the right child exist
                    current.add(parent.right);  // add the right children to the current level
                }
            }
        }

        return results; // return the arraylist of linkedlists for each level of binary tree
    }
}















