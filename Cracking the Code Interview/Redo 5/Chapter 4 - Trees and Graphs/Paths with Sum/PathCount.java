public class PathCount {
    public int getNumberOfPathCount(TreeNode root, int targetSum) {
        return getNumberOfPathCount(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    private int getNumberOfPathCount(TreeNode root, int targetSum, int currentSum, HashMap<Integer, Integer> pathCount) {
        if (root == null) return 0;

        currentSum += root.data;
        int totalPaths = pathCount.getOrDefault(currentSum - targetSum, 0);

        if (currentSum == targetSum) {
            totalPaths++;
        }

        incrementPathCount(pathCount, currentSum);
        totalPaths += getNumberOfPathCount(root.left, targetSum, currentSum, pathCount);
        totalPaths += getNumberOfPathCount(root.right, targetSum, currentSum, pathCount);
        decrementPathCount(pathCount, currentSum);

        return totalPaths;
    }

    private void decrementPathCount(HashMap<Integer, Integer> pathCount, int sum) {
        if (!pathCount.containsKey(sum)) {
            return;
        } else {
            pathCount.put(sum, pathCount.get(sum) - 1);

            if (pathCount.get(sum) == 0) {
                pathCount.remove(sum);
            }
        }
    }

    private void incrementPathCount(HashMap<Integer, Integer> pathCount, int sum) {
        if (!pathCount.containsKey(sum)) {
            pathCount.put(sum, 0);
        }

        pathCount.put(sum, pathCount.get(sum) + 1);
    }
}