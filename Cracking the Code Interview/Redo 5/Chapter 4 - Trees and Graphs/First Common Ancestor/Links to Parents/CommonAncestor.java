public class CommonAncestor {
    public TreeNode commonAncestor(TreeNode node1, TreeNode node2) {
        int delta = depth(node1) - depth(node2);
        TreeNode shallowerNode = delta > 0 ? node2 : node1;
        TreeNode deeperNode = delta > 0 ? node1 : node2;

        deeperNode = moveNodeUp(deeperNode, Math.abs(delta));

        while (shallowerNode != null && deeperNode != null && shallowerNode != deeperNode) {
            shallowerNode = shallowerNode.parent;
            deeperNode = deeperNode.parent;
        }

        return shallowerNode == null || deeperNode == null ? null : shallowerNode;
    }

    private TreeNode moveNodeUp(TreeNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }

        return node;
    }

    private int depth(TreeNode node) {
        int depth = 0;

        TreeNode current = node;
        while (current != null) {
            current = current.parent;
            depth++;
        }

        return depth;
    }
}