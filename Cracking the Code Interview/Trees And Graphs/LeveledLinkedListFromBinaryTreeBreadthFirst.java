package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class LeveledLinkedListFromBinaryTreeBreadthFirst {

    public ArrayList<LinkedList<TreeNode>> createLeveledLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();

        LinkedList<TreeNode> current = new LinkedList<>();

        if (root != null) current.add(root);

        while (current.size() > 0) {
            lists.add(current);

            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();

            for (TreeNode parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }

                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }

        return lists;
    }

    private class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
