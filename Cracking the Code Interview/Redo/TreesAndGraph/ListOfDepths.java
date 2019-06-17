package Redo.TreesAndGraph;

import CodeLibrary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {
    private ArrayList<LinkedList<TreeNode>> getDepths(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> list = new ArrayList<>();
        getDepths(root, list, 0);
        return list;
    }

    private void getDepths(TreeNode node, ArrayList<LinkedList<TreeNode>> list, int level) {
        if (node == null) return;

        LinkedList<TreeNode> nodes = null;

        if (list.size() == level) {
            nodes = new LinkedList<>();
            list.add(nodes);
        } else {
            nodes = list.get(level);
        }

        nodes.add(node);

        getDepths(node.left, list, level + 1);
        getDepths(node.right, list, level + 1);
    }
}
