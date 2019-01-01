package TreesAndGraph;

import CodeLibrary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

// given a binary tree, design an algorithm which creates a linked list of all the nodes at
// each depth or level
public class ListOfDepths {
    // we have to keep track of the level that we are currently on
    // also need a array of linkedlist to keep track of each level

    public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();  // arraylist of linkedlist for each level
        createLevelLinkedList(root, lists, 0);  // starting at level 0
        return lists;
    }

    private void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) {
            return; // we have found the base case. At the bottom of the binary tree
        }

        LinkedList<TreeNode> list = null;
        if (lists.size() == level) {    // do not have this level in the linkedlist yet
            list = new LinkedList<>();
            lists.add(list);    // add a new list to lists
        } else {    // there is already a list inside the arraylist
            list = lists.get(level);     // retrieve the list
        }

        list.add(root); // add the current node
        createLevelLinkedList(root.left, lists, level + 1); // go down the left tree, level + 1
        createLevelLinkedList(root.right, lists, level + 1);    // go down the right tree, level to 1
    }
}













