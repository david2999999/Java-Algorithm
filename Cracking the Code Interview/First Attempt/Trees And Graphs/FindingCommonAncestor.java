package TreesAndGraphs;

public class FindingCommonAncestor {
    private TreeNode FindingAncestor(TreeNode p, TreeNode q) {
        if (p == null || q == null) return null;

        int delta = depth(p) - depth(q);

        TreeNode first = delta > 0 ? q : p;  // shallow node
        TreeNode second = delta > 0 ? p : q; // deeper node

        second = goUpBy(second, Math.abs(delta));

        while (first != null && second != null && first != second) {
            first = first.parent;
            second = second.parent;
        }

        return (first == null || second == null) ? null : first;

    }

    private TreeNode goUpBy(TreeNode node, int index) {
        while (index > 0 && node != null) {
            node = node.parent;
            index--;
        }

        return node;
    }

    private int depth(TreeNode node) {
        int nodeDepth = 0;

        while (node != null) {
            node = node.parent;
            nodeDepth++;
        }

        return nodeDepth;
    }


    private class TreeNode {
        public TreeNode parent;
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
