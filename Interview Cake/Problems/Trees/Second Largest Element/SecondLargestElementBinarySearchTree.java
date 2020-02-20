public class SecondLargestElementBinarySearchTree {
    public int findSecondLargest(BinaryTreeNode rootNode) {
        if (rootNode == null || (rootNode.left == null && rootNode.right == null)) {
            throw new IllegalArgumentException("Tree must have at least 2 nodes");
        }

        if (rootNode.left != null && rootNode.right == null) {
            return findLargest(rootNode.left);
        }

        if (rootNode.right != null &&
                rootNode.right.left == null &&
                rootNode.right.right == null) {
            return rootNode.value;
        }

        return findSecondLargest(rootNode.right);
    }

    private int findLargest(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            throw new IllegalArgumentException("Tree must have at least 1 node.");
        }

        if (rootNode.right != null) {
            return findLargest(rootNode.right);
        }

        return rootNode.value;
    }
}