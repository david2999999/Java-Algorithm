public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            this.element = e;
            this.parent = above;
            this.left = leftChild;
            this.right = rightChild;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {}

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");

        Node<E> node = (Node<E>) p;
        if (node.getParent() == node) {
            throw new IllegalArgumentException("P is no longer in the tree");
        }

        return node;
    }

    public int size() {
        return size;
    }

    public Position<E> root() {
        return root;
    }

    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty.");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("P already has a left child");
        }

        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) {
            throw new IllegalStateException("P already has a right child");
        }

        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    public void attach(Position<E> p, LinkedBinaryTree<E> t1,
                       LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) throw new IllegalArgumentException("P must be a leaf");

        size += t1.size() + t2.size();

        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }

        if (!t2.isEmpty()) {
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2) {
            throw new IllegalArgumentException("P has two children");
        }

        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());

        if (child != null) {
            child.setParent(node.getParent());
        }

        if (node == root) {
            root = child;
        } else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }

        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return temp;
    }

    public static <V, E> void DFS(Graph<V, E> g, Vertex<V> u, Set<Vertex<V>> known,
                                  Map<Vertex<V>, Edge<E>> forest) {
        known.add(u);
        for (Edge<E> e: g.outgoingEdges(u)) {
            Vertex<V> v = g.opposite(u, e);
            if (!known.contains(v)) {
                forest.put(v, e);
                DFS(g, v, known, forest);
            }
        }
    }

    public static <V, E> PositionalList<Edge<E>> constructPath(Graph<V, E> g, Vertex<V> u, Vertex<V> v,
                                                               Map<Vertex<V>, Edge<E>> forest) {
        PositionalList<Edge<E>> path = new LinkedPositionalList<>();

        if (forest.get(v) != null) {
            Vertex<V> walk = v;
            while (walk != u) {
                Edge<E> edge = forest.get(walk);
                path.addFirst(edge);
                walk = g.opposite(walk, edge);
            }
        }

        return path;
    }
}