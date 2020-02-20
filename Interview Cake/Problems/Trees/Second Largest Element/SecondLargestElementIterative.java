public class SecondLargestElementIterative {
    private int findSecondLargestElement(BinaryTreeNode rootNode) {
        if (rootNode == null || (rootNode.left == null && rootNode.right == null)) {
            throw new IllegalArgumentException("Tree must have at least 2 nodes");
        }

        BinaryTreeNode current = rootNode;

        while (true) {
            if (current.left != null && current.right == null) {
                return findLargest(current.left);
            }

            if (current.right != null &&
                    current.right.left == null &&
                    current.right.right == null) {
                return current.value;
            }

            current = current.right;
        }
    }

    private int findLargest(BinaryTreeNode root) {
        BinaryTreeNode current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current.value;
    }
}