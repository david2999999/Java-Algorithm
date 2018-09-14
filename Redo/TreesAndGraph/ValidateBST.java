package Redo.TreesAndGraph;

import CodeLibrary.TreeNode;

public class ValidateBST {
    int index = 0;

    private void copyBST(TreeNode node, int[] arr) {
        if (node == null) return;

        copyBST(node.left, arr);
        arr[index] = node.data;
        index++;
        copyBST(node.right, arr);
    }

    public boolean checkBST(TreeNode node) {
        int[] arr = new int[node.size()];
        copyBST(node, arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }

        return true;
    }
}
