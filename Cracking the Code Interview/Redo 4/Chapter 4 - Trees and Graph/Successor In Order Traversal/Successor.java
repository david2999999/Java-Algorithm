public class Successor {
    public TreeNode inOrderSuccessor(TreeNode n) {
        if (n == null) return null;

        if (n.right != null) {
            return leftMostChild(n.right);
        }
    }

    private TreeNode leftMostChild(TreeNode n) {
        if (n == null) return null;

        while (n.left != null) {
            n = n.left;
        }

        return n;
    }
}