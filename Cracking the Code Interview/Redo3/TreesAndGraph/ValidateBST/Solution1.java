package TreesAndGraph.ValidateBST;

import CodeLibrary.TreeNode;

public class Solution1 {
    private int index = 0;

    private void copyBST(TreeNode root, int[] array) {
        if (root == null) return;

        copyBST(root.left, array);
        array[index++] = root.data;
        copyBST(root.right, array);
    }

    public boolean checkBST(TreeNode root) {
        int[] array = new int[root.size()];
        copyBST(root, array);

        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) return false;
        }

        return true;
    }

}
