public class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Position<E> p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }

    public int height(Position<E> p) {
        int h = 0;
        for (Position<E> c: children(p))
            h = Math.max(h, 1 + height(c));

        return h;
    }

    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> positionIterator = positions().iterator();

        public boolean hasNext() {
            return positionIterator.hasNext();
        }

        public E next() {
            return positionIterator.next().getElement();
        }

        public void remove() {
            positionIterator.remove();
        }
    }

    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public Iterable<Position<E>> positions() {
        return preorder();
    }

    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            preOrderSubtree(root(), snapshot);
        }

        return snapshot;
    }

    private void preOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);
        for (Position<E> c: children(p)) {
            preOrderSubtree(c, snapshot);
        }
    }

    public Iterable<E> postOrder() {
        List<E> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            postOrderSubtree(root(), snapshot);
        }

        return snapshot;
    }

    public void postOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> child: children(p)) {
            snapshot.add(child);
        }

        snapshot.add(p);
    }

    public Iterable<Position<E>> breathFirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root());

            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue();
                snapshot.add(p);

                for (Position<E> child: children(p)) {
                    fringe.enqueue(child);
                }
            }
        }

        return snapshot;
    }
}






















