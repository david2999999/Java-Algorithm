package TreesAndGraph.ListOfDepths;

import CodeLibrary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution1 {
    public void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;

        LinkedList<TreeNode> list = null;

        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }
}
