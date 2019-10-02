package Hard.BiNode;

public class Solution2 {
    public BiNode convert(BiNode root) {
        if (root == null) return null;

        BiNode part1 = convert(root.node1);
        BiNode part2 = convert(root.node2);

        if (part1 != null) {
            concat(getTail(part1), root);
        }

        if (part2 != null) {
            concat(root, part2);
        }

        return part1 == null ? root : part1;
    }

    private void concat(BiNode x, BiNode y) {
        x.node2 = y;
        y.node1 = x;
    }

    private BiNode getTail(BiNode node) {
        if (node == null) return null;
        while (node.node2 != null) {
            node = node.node2;
        }
        return node;
    }
}
