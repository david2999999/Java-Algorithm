package Hard.BiNode;

public class Solution1 {
    public NodePair convert(BiNode root) {
        if (root == null) return null;

        NodePair part1 = convert(root.node1);
        NodePair part2 = convert(root.node2);

        if (part1 != null) {
            concat(part1.tail, root);
        }

        if (part2 != null) {
            concat(root, part2.head);
        }

        return new NodePair(part1 == null ? root : part1.head,
                part2 == null ? root : part2.tail);
    }

    private void concat(BiNode x, BiNode y) {
        x.node2 = y;
        y.node1 = x;
    }
}
