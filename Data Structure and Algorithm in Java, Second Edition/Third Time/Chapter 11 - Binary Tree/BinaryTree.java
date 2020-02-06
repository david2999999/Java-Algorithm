public class BinaryTree<E> extends AbstractCollection {
    protected E root;
    protected BinaryTree<E> left, right, parent;
    protected int size;

    public BinaryTree() {}

    public BinaryTree(E root) {
        this.root = root;
        this.size = 1;
    }

    public BinaryTree(E root, BinaryTree<E> left, BinaryTree<E> right) {
        this(root);
        if (left != null) {
            this.left = left;
            left.parent = this;
            this.size += left.size;
        }

        if (right != null) {
            this.right = right;
            right.parent = this;
            this.size += right.size;
        }
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } else if (!(object instanceof BinaryTree)) {
            return false;
        }

        BinaryTree that = (BinaryTree) object;

        return that.root.equals(this.root) &&
                that.size == this.size &&
                that.right.equals(this.right) &&
                that.left.equals(this.left) &&
                that.parent.equals(this.parent);
    }
}