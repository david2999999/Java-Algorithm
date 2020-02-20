public class ValidBinarySearchTree {
    public boolean isBinarySearchTree(BinaryTreeNode root) {
        if (root == null) {
            return false;
        }

        Deque<NodeBounds> nodeAndBoundsStack = new ArrayDeque<>();
        nodeAndBoundsStack.add(new NodeBounds(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while (!nodeAndBoundsStack.isEmpty()) {
            NodeBounds nb = nodeAndBoundsStack.pop();
            BinaryTreeNode node = nb.node;
            int lowerBound = nb.lowerBound;
            int upperBound = nb.upperBound;

            if (node.value <= lowerBound || node.value >= upperBound) {
                return false;
            }

            if (node.left != null) {
                nodeAndBoundsStack.push(new NodeBounds(node.left, lowerBound, node.value));
            }

            if (node.right != null) {
                nodeAndBoundsStack.push(new NodeBounds(node.right, node.value, upperBound));
            }
        }

        return true;
    }
}