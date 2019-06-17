package Redo.TreesAndGraph.SumPath;

import CodeLibrary.TreeNode;

import java.util.HashMap;

public class Optimized {
    private int findSumPaths(TreeNode root, int target) {
        if (root == null) return 0;

        return findSumPaths(root, target, 0, new HashMap<>());
    }

    private int findSumPaths(TreeNode root, int target, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (root == null) return 0;

        runningSum += root.data;
        int sum = runningSum - target;
        int paths = pathCount.getOrDefault(sum, 0);

        if (runningSum == target) {
            paths++;
        }

        incrementHashTable(pathCount, runningSum, 1);
        paths += findSumPaths(root.left, target, runningSum, pathCount);
        paths += findSumPaths(root.right, target, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);

        return paths;
    }

    private void incrementHashTable(HashMap<Integer,Integer> pathCount, int runningSum, int delta) {
        int count = pathCount.getOrDefault(runningSum, 0) + delta;
        if (count == 0) {
            pathCount.remove(runningSum);
        } else {
            pathCount.put(runningSum, count);
        }
    }
}
