public class SuperBalanceBinaryTree {
    public boolean isSuperBalance(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }

        List<Integer> depths = new ArrayList<>(3);

        Deque<NodeDepthPair> nodes = new ArrayDeque<>();
        nodes.push(new NodeDepthPair(root, 0));

        while (!nodes.isEmpty()) {
            NodeDepthPair nodeDepthPair = nodes.pop();
            BinaryTreeNode node = nodeDepthPair.node;
            int depth = nodeDepthPair.depth;

            if (node.left == null && node.right == null) {
                if (!depths.contains(depth)) {
                    depths.add(depth);

                    if (depths.size() > 2 || (depths.size() == 2 &&
                            Math.abs(depths.get(0) - depths.get(1)) > 1)) {
                        return false;
                    }
                }
            } else {
                if (node.left != null) {
                    nodes.push(new NodeDepthPair(node.left, depth + 1));
                }

                if (node.right != null) {
                    nodes.push(new NodeDepthPair(node.right, depth + 1));
                }
            }
        }

        return true;
    }
}