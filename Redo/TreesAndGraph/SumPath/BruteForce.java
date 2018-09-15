package Redo.TreesAndGraph.SumPath;


import CodeLibrary.TreeNode;

public class BruteForce {
    private int sumPaths(TreeNode root, int target) {
        if (root == null) return 0;

        int pathsFromRoot = sumPathsFromRoot(root, target, 0);

        int pathsFromLeft = sumPaths(root.left, target);
        int pathsFromRight = sumPaths(root.right, target);

        return pathsFromRoot + pathsFromLeft + pathsFromRight;
    }

    private int sumPathsFromRoot(TreeNode root, int target, int current) {
        if (root == null) return 0;


        int totalPath = 0;
        current += root.data;

        if (current == target) {
            totalPath++;
        }

        totalPath += sumPathsFromRoot(root.left, target, current);
        totalPath += sumPathsFromRoot(root.right, target, current);

        return totalPath;
    }
}
