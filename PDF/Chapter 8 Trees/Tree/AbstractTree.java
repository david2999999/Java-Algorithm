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