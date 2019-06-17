package Redo.TreesAndGraph.Subtree;

import CodeLibrary.TreeNode;

public class SubtreeOptimized {
    private boolean isSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;

        return checkSubTree(t1, t2);
    }

    private boolean checkSubTree(TreeNode node1, TreeNode node2) {
        if (node1 == null) return false;
        else if (node1.data == node2.data && checkMatch(node1, node2)) {
            return true;
        }

        return checkSubTree(node1.left, node2) || checkSubTree(node1.right, node2);
    }

    private boolean checkMatch(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        else if (node1 == null || node2 == null) return false;
        else if (node1.data != node2.data) return false;
        else {
            return checkMatch(node1.left, node2.left) && checkMatch(node1.right, node2.right);
        }
    }


}
