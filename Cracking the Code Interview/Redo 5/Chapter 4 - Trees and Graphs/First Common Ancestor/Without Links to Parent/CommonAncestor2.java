public class CommonAncestor2 {
    private static class Result {
        public TreeNode node;
        public boolean isAncestor;

        public Result(TreeNode node, boolean isAncestor) {
            this.node = node;
            this.isAncestor = isAncestor;
        }
    }

    public TreeNode commonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        Result result = commonAncestorHelper(root, node1, node2);

        if (result.isAncestor) {
            return result.node;
        }

        return null;
    }

    public Result commonAncestorHelper(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return new Result(null, false);
        }

        if (root == node1 && root == node2) {
            return new Result(root, true);
        }

        Result resultLeft = commonAncestorHelper(root.left, node1, node2);
        if (resultLeft.isAncestor) {
            return resultLeft;
        }

        Result resultRight = commonAncestorHelper(root.right, node1, node2);
        if (resultRight.isAncestor) {
            return resultRight;
        }

        if (resultLeft.node != null && resultRight.node != null) {
            return new Result(root, true);
        } else if (root == node1 || root == node2) {
            boolean isAncestor = resultLeft.node != null || resultRight.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(resultLeft.node != null ? resultLeft.node : resultRight.node, false);
        }
    }
}












