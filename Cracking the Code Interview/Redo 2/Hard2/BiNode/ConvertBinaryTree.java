package Hard2.BiNode;

// consider a simple data structure called BiNode, which as pointers to two other nodes.
// This data structure BiNode could be used to represent both a binary tree and LinkedList
// write a method to convert a binary tree to linkedlist
public class ConvertBinaryTree {
    // lets create the BiNode class first
    // we also need a class to keep track of the head and tail of the linked list
    private static class NodePair {
        public BiNode head, tail;   // head and tail of a linkedlist

        public NodePair(BiNode head, BiNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    // converting binary tree to linkedlist recursively
    public NodePair convert(BiNode root) {
        if (root == null) return null;  // base case

        NodePair part1 = convert(root.node1);   // convert the left side of the tree
        NodePair part2 = convert(root.node2);   // convert the right side of the tree

        if (part1 != null) {    // if the left side is not null
            concat(part1.tail, root);   // prepend the left side to the root
        }

        if (part2 != null) {    // if the right side is not null
            concat(root, part2.head);   // append the right side to the root
        }

        // if the left side is null, then root will be the beginning of the list
        // if the right side is null, then root will be the end of the list

        // if the left side is not null, we want the beginning of the left side to be the beginning of the list
        // if the right side is not null, we want the end of the right side to be the end of the list
        return new NodePair(part1 == null ? root : part1.head,
                            part2 == null ? root : part2.tail);
    }

    private void concat(BiNode x, BiNode y) {
        // links the two node together
        x.node2 = y;    // x -> y
        y.node1 = x;    // x <- y
    }
}
















