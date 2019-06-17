package CodeLibrary;

// binary tree node
public class TreeNode {
    public int data;
    public TreeNode left, right, parent;    // access to the nodes on the left, right and parent
    private int size = 0;   // keeps track of the size of this subtree

    public TreeNode(int d) {
        data = d;
        size = 1;   // only 1 node currently, without any children nodes
    }

    public void insertInOrder(int d) {
        if (d <= data) {    // d is less than the data in the current node, insert on left side of tree
            if (left == null) { // found a position to insert the node
                setLeftChild(new TreeNode(d));
            } else {
                left.insertInOrder(d);  // recurse into the left subtree
            }
        } else { // d is greater than the data in the current node, insert on right side of tree
            if (right == null) {    // found a position to insert the node
                setRightChild(new TreeNode(d));
            } else {
                right.insertInOrder(d); // recurse into the right subtree
            }
        }

        size++; // successfully added a node, increment the size
    }

    public int size() {
        return size;    // return the size of this subtree
    }

    // finding a node in this subtree
    public TreeNode find(int d) {
        if (d == data) {    // we have found the data
            return this;
        } else if (d <= data) { // if the data is smaller than or equal to the current node, search left tree
            return left != null ? left.find(d) : null;
        } else if (d > data) {   // if the data is greater than the current node, search right tree
            return right != null ? right.find(d) : null;
        }

        return null;    // we have not found the node
    }

    private void setRightChild(TreeNode treeNode) {
        this.right = right;

        if (right != null) { // connect the right node to its parent
            right.parent = this;
        }
    }

    private void setLeftChild(TreeNode left) {
        this.left = left;

        if (left != null) { // connect the left node to its parent
            left.parent = this;
        }
    }
}
