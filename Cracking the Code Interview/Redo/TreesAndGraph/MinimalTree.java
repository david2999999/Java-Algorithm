package Redo.TreesAndGraph;

import CodeLibrary.TreeNode;

public class MinimalTree {
    private TreeNode generateMinTree(int array[]) {
        return generateMinTree(array, 0, array.length - 1);
    }

    private TreeNode generateMinTree(int array[], int start, int end) {
        if (end < start) return null;

        int mid = (start + end) / 2;

        TreeNode n = new TreeNode(array[mid]);
        n.left = generateMinTree(array, start, mid - 1);
        n.right = generateMinTree(array, mid + 1, end);

        return n;
    }
}
