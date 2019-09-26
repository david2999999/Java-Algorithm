public class BalancedBinaryTree {
    public Node rebalanceTree(Node root) {
        ArrayList<Node> nodes = new ArrayList<>();
        storeBSTNodes(nodes, root);

        int size = nodes.size();
        return buildBalancedBinaryTree(nodes, 0, size - 1);
    }

    private Node buildBalancedBinaryTree(ArrayList<Node> nodes, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node node = nodes.get(mid);

        node.left = buildBalancedBinaryTree(nodes, start, mid - 1);
        node.right = buildBalancedBinaryTree(nodes, mid + 1, end);

        return node;
    }

    private void storeBSTNodes(ArrayList<Node> nodes, Node root) {
        if (root == null) return;

        storeBSTNodes(nodes, root.left);
        nodes.add(root);
        storeBSTNodes(nodes, root.right);
    }
}