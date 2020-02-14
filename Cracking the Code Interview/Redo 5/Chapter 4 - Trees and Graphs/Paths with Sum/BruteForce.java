public class BruteForce {
    public int countPathWithSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int pathsFromRoot = countPathOfSumsFromNode(root, targetSum, 0);

        pathsFromRoot += countPathWithSum(root.left, targetSum);
        pathsFromRoot += countPathWithSum(root.right, targetSum);

        return pathsFromRoot;
    }

    private int countPathOfSumsFromNode(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return 0;
        }

        currentSum += root.data;

        int totalPaths = 0;
        if (currentSum == targetSum) {
            totalPaths++;
        }

        totalPaths += countPathOfSumsFromNode(root.left, targetSum, currentSum);
        totalPaths += countPathOfSumsFromNode(root.right, targetSum, currentSum);
        return totalPaths;
    }
}