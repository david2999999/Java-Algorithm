package Hard.BiNode;

public class ConvertToCircularLinkedList {
    public BiNode convertToCircular(BiNode root) {
        if (root == null) return null;

        BiNode part1 = convertToCircular(root.node1);
        BiNode part3 = convertToCircular(root.node2);

        if (part1 == null && part3 == null) {
            root.node1 = root;
            root.node2 = root;
            return root;
        }

        BiNode tail3 = (part3 == null) ? null : part3.node1;

        if (part1 == null) {
            concat(part3.node1, root);
        } else {
            concat(part1.node1, root);
        }

        if (part3 == null) {
            concat(root, part1);
        } else {
            concat(root, part3);
        }

        if (part1 != null && part3 != null)
            concat(tail3, part1);

        return part1 == null ? root : part1;
    }

    private void concat(BiNode x, BiNode y) {
        x.node2 = y;
        y.node1 = x;
    }

}
