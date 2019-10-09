public class BinarySearchTree2 {
    public boolean validBST(TreeNode n) {
        return validBST(n, null, null);
    }

    public boolean validBST(TreeNode n, Integer min, Integer max) {
        if (n == null) return true;

        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }

        if ((!validBST(n.left, min, n.data) || (!validBST(n.right, n.data, max)))) {
            return false;
        }

        return true;
    }
}