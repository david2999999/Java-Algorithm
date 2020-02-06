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

    public int hashCode() {
        return root.hashCode() + left.hashCode() + right.hashCode() + size;
    }

    public int size() {
        return size;
    }

    public Iterator iterator() {
        return new java.util.Iterator() { // anonymous inner class
            private boolean rootDone;
            private Iterator lIt, rIt; // child iterators

            public boolean hasNext() {
                return !rootDone || lIt != null && lIt.hasNext()
                        || rIt != null && rIt.hasNext();
            }

            public Object next() {
                if (rootDone) {
                    if (lIt != null && lIt.hasNext()) {
                        return lIt.next();
                    }
                    if (rIt != null && rIt.hasNext()) {
                        return rIt.next();
                    }
                    return null;
                }
                if (left != null) {
                    lIt = left.iterator();
                }
                if (right != null) {
                    rIt = right.iterator();
                }
                rootDone = true;
                return root;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public abstract class BinaryTreeIterator implements Iterator {
        protected boolean rootDone;
        protected Iterator leftIterator, rightIterator;

        public boolean hasNext() {
            return !rootDone ||
                    leftIterator != null && leftIterator.hasNext() ||
                    rightIterator != null && rightIterator.hasNext();
        }

        public abstract Object next();
        public void remove () {
            throw new UnsupportedOperationException();
        }
    }

    public class PreOrder extends BinaryTreeIterator {
        public PreOrder() {
            if (left != null) lIt = left.new PreOrder();
            if (right != null) rIt = right.new PreOrder();
        }

        public Object next() {
            if (!rootDone) {
                rootDone = true;
                return root;
            }

            if (leftIterator != null && leftIterator.hasNext()) return leftIterator.next();
            if (rightIterator != null && rightIterator.hasNext()) return rightIterator.next();
            return null;
        }
    }
}