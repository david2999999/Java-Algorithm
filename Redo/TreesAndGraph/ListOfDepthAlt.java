package Redo.TreesAndGraph;

import CodeLibrary.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepthAlt {
    private ArrayList<LinkedList<TreeNode>> getDepths(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();

        if (root != null) current.add(root);

        while (current.size() > 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();


            for (TreeNode node: parents) {
                if (node.left != null) {
                    current.add(node.left);
                }

                if (node.right != null) {
                    current.add(node.right);
                }
            }
        }

        return result;
    }
}
