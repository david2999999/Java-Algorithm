package Redo.TreesAndGraph;

import CodeLibrary.TreeNode;

public class ValidateBSTEfficient {
    Integer previousValue = null;

    private boolean checkBST(TreeNode node) {
        if (node == null) return true;

        if (!checkBST(node.left)) return false;

        if (previousValue != null && node.data <= previousValue) {
            return false;
        }

        previousValue = node.data;

        if (!checkBST(node.right)) return false;

        return true;

    }
}
