package Hard2.BiNode;

// consider a simple data structure called BiNode, which as pointers to two other nodes.
// This data structure BiNode could be used to represent both a binary tree and LinkedList
// write a method to convert a binary tree to linkedlist
public class ConvertBinaryTree2 {
    // BiNode class is shown in the previous video

    // in this example we will return the head of the linkedlist
    // because with the head of the linkedlist, we can just traverse to retrieve the tail
    public BiNode convert(BiNode root) {
        if (root == null) return null;  // base case

        BiNode part1 = convert(root.node1); // convert the left side of the tree
        BiNode part2 = convert(root.node2); // convert the right side of the tree

        // if the left side is not null
        if (part1 != null) {
            concat(getTail(part1), root);   // prepend the end of the left side to the root
        }

        // if the right side is not null
        if (part2 != null) {
            concat(root, part2);    // append the beginning of the right side to the root
        }

        // check if the left side is null
        // if it is null, then the root is the beginning of the list
        // else part1 (the beginning of left side) is the beginning of the list
        return part1 == null ? root : part1;
    }

    // retrieves the tail of the node
    private BiNode getTail(BiNode node) {
        if (node == null) return null;  // invalid param

        // while node.next is not null
        while (node.node2 != null) {
            node = node.node2;
        }

        return node;    // the tail of the linkedlist
    }

    // concats two nodes together
    private void concat(BiNode x, BiNode y) {
        // links the two node together
        x.node2 = y;    // x -> y
        y.node1 = x;    // x <- y
    }
}












