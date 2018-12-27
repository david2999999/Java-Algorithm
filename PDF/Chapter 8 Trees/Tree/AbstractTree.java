public abstract class AbstractTree<E> implements Tree<E> {
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = positions().iterator();
        public boolean hasNext() {
            return posIterator.hasNext();
        }
        
        public E next() {
            return posIterator.next().getElement();
        }
        
        public void remove() {
            posIterator.remove();
        }
    }
    
    public Iterable<Position<E>> positions() { return preorder(); }
    
    public Iterator<E> iterator() { return new ElementIterator(); }
    
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            preOrderSubtree(root(), snapshot);
        return snapshot;
    }
    
    private void preOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);
        for (Position<E> c: children(p))
            preOrderSubtree(c, snapshot);
    }
    
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) 
            postorderSubtree(root(), snapshot):
            
        return snapshot;
    }
    
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c: children(p))
            postorderSubtree(c, snapshot);
        snapshot.add(p);
    }
    
    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root());
            while(!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue();
                snapshot.add(p);
                for (Position<E> c: children(p))
                    fringe.enqueue(c);
            }
        }
        
        return snapshot;
    }
    
    public static <E> void printPreorderIndent(Tree<E> T, Position<E> p, int d) {
        System.out.println(spaces(2 * d) + p.getElement());
        for (Position<E> c: T.children(p))
            printPreorderIndent(T, c, d + 1);
    }
    
    private static String spaces(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(' ');
        }
        
        return sb.toString();
    } 
    
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
        if (isRoot(p))
            return 0;
        else 
            return 1 + depth(parent(p));
    }
    
    public int height(Position<E> p) {
        int h = 0;
        
        for (Position<E> c: children(p)) {
            h = Math.max(h, 1 + height(c));
        }
        
        return h;
    }
}