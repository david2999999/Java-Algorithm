public class DeepestNode {
    private static class TreeNode {
        public int right;
        public int left;
    }

    public TreeNode findDeepestNode(TreeNode root) {
        if (root == null) return null;

        List<TreeNode> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            result.add(current);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return result.get(result.size() - 1);
    }
}