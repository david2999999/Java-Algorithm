public class ValidBinarySearchTreeRecursion {
    public boolean isBinarySearchTree(BinaryTreeNode root) {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Intger.MAX_VALUE);
    }

    private boolean isBinarySearchTree(BinaryTreeNode root, int lowerBound, int upperBound) {
        if (root == null) {
            return true;
        }

        if (root.value <= lowerBound || root.value >= upperBound) {
            return false;
        }

        return isBinarySearchTree(root.left, lowerBound, node.value) &&
                isBinarySearchTree(root.rught, root.value, upperBound);
    }
}