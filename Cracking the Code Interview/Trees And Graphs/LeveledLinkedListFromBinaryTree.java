package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class LeveledLinkedListFromBinaryTree {
    public void createLeveledLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
        if (root == null) return;

        LinkedList<TreeNode> list;

        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(root);

        createLeveledLinkedList(root.left, lists, level + 1);
        createLeveledLinkedList(root.right, lists, level + 1);
    }

    public ArrayList<LinkedList<TreeNode>> createLeveledLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLeveledLinkedList(root, lists, 0);

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
