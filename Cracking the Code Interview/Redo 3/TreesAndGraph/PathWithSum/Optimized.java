package TreesAndGraph.PathWithSum;

import TreesAndGraph.RandomNode.TreeNode;

import java.util.HashMap;

public class Optimized {
    public int countPathsWithSum(TreeNode root, int targetSum) {
        return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    private int countPathsWithSum(TreeNode node, int targetSum,
                                  int runningSum, HashMap<Integer,Integer> pathCount) {
        if (node == null) return 0;

        runningSum += node.getData();
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        if (runningSum == targetSum) {
            totalPaths++;
        }

        incrementHashtable(pathCount, runningSum, 1);
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashtable(pathCount, runningSum, -1);
        return totalPaths;
    }

    private void incrementHashtable(HashMap<Integer,Integer> pathCount, int key, int delta) {
        int newCount = pathCount.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            pathCount.remove(key);
        } else {
            pathCount.put(key, newCount);
        }
    }
}
