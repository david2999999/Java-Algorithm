package Hard2.BiNode;

// consider a simple data structure called BiNode, which as pointers to two other nodes.
// This data structure BiNode could be used to represent both a binary tree and LinkedList
// write a method to convert a binary tree to linkedlist
public class ConvertBinaryTree3 {
    // concats two nodes together
    private void concat(BiNode x, BiNode y) {
        // links the two node together
        x.node2 = y;    // x -> y
        y.node1 = x;    // x <- y
    }

    // in this example, we will convert the binary tree to a circular linkedlist first
    // then make the circular linkedlist into a regular linkedlist
    public BiNode convertToCircular(BiNode root) {
        if (root == null) return null;  // base case

        BiNode part1 = convertToCircular(root.node1);   // convert left side of tree to circular linkedlist
        BiNode part3 = convertToCircular(root.node2);   // convert right side of tree to circular linkedlist

        // if both the left and the right are null
        if (part1 == null && part3 == null) {
            // create a circular linkedlist with just the root node
            root.node1 = root;
            root.node2 = root;
            return root;
        }

        // finding the tail of the right side
        // if the right side is null, tail3 = null
        // else part3.node1 is the tail
        // Note: node1 is the tail of part3 because it is a circular linkedlist, everything goes around
        BiNode tail3 = (part3 == null) ? null : part3.node1;

        // joining the left side to the root
        if (part1 == null) {    // if the left side is null
            concat(part3.node1, root);  // join the tail of the right part to the root
        } else {
            concat(part1.node1, root);  // joining the tail of the left part to root
        }

        // joining the right side to the root
        if (part3 == null) {    // if the right side is null
            concat(root, part1);    // join the root with the head of the left side
        } else {
            concat(root, part3);    // join the root with the head of the right side
        }

        // if both sides are not null
        if (part1 != null && part3 != null) {
            concat(tail3, part1);   // join the tail of the right side, with the head of the left side
                                    // just remember: its circular linkedlist
        }

        // if the left side is null, return the root
        // else return the head of the left side
        return part1 == null ? root : part1;
    }

    public BiNode convert(BiNode root) {
        BiNode head = convertToCircular(root);  // get the head of the circular linkedlist

        // disconnect the connections of the circular linkedlist
        head.node1.node2 = null;
        head.node1 = null;

        return head;    // head of the linkedlist
    }

}














