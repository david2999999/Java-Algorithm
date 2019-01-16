public class TreeMap<K, V> extends AbstractSortedMap<K, V> {
    protected static class BalanceableBinaryTree<K, V> extends LinkedBinaryTree<Entry<K, V>> {
        protected static class BSTNode<E> extends Node<E> {
            int aux = 0;
            BSTNode(E e, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
                super(e, parent, leftChild, rightChild);
            }
            
            public int getAux() {
                return aux;
            }
            
            public void setAux(int value) {
                aux = value;
            }
        }
        
        public int getAux(Position<Entry<K, V>> p) {
            return ((BSTNode<Entry<K, V>>)p).getAux();
        }
        
        public void setAux(Position<Entry<K, V>> p, int value) {
            ((BSTNode<Entry<K,V>>) p).setAux(value);
        }
        
        protected Node<Entry<K,V>> createNode(Entry<K, V> e, Node<Entry<K,V>> parent, Node<Entry<K,V>> left, Node<Entry<K,V>> right) {
            return new BSTNode<>(e, parent, left, right);
        }
        
        private void relink(Node<Entry<K, V>> parent, Node<Entry<K, V>> child, boolean makeLeftChild) {
            child.setParent(parent);
            if (makeLeftChild) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
        
        public void rotate(Position<Entry<K, V>> p) {
            Node<Entry<K,V>> x = validate(p);
            Node<Entry<K,V>> y = x.getParent();
            Node<Entry<K,V>> z = y.getParent();
            
            if (z == null) {
                root = x;
                x.setParent(null);
            } else {
                relink(z, x, y == z.getLeft());
            }
            
            if (x == y.getLeft()) {
                relink(y, x.getRight(), true);
                relink(x, y, false);
            } else {
                relink(y, x.getLeft(), false);
                relink(x, y, true);
            }
        }
        
        public Position<Entry<K, V>> restructure(Position<Entry<K, V>> x) {
            Position<Entry<K, V>> y = parent(x);
            Position<Entry<K, V>> z = parent(y);
            if ((x == right(y) == (y == right(z)))) {
                rotate(y);
                return y;
            } else {
                rotate(x);
                rotate(x);
                return x;
            }
        }
    }
    
    
    protected BalanceableBinaryTree<K,V> tree = new BalanceableBinaryTree<>();
    
    public TreeMap() {
        super();
        tree.addRoot(null);
    }
    
    public TreeMap(Comparator<K> comp) {
        super(comp);
        tree.addRoot(null);
    }
    
    public int size() {
        return (tree.size() - 1) / 2; // only internal nodes have entries
    }
    
    private void expandExternal(Position<Entry<K, V>> p, Entry<K, V> entry) {
        tree.set(p, entry);
        tree.addLeft(p, null);
        tree.addRight(p, null);
    }
    
    protected Position<Entry<K,V>> root() { return tree.root(); }
    
    private Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> p, K key) {
        if (isExternal(p))
            return p;
        
        int comp = compare(key, p.getElement());
        
        if (comp == 0)
            return p;
        else if (comp < 0)
            return treeSearch(left(p), key);
        else 
            return treeSearch(right(p), key);
    }
    
    public V get(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        rebalanceAccess(p); // hook for balanced tree subclasses
        if (isExternal(p)) return null;
        return p.getElement().getValue();
    }
    
    public V put(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newEntry = new MapEntry<>(key, value);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        
        if (isExternal(p)) {
            expandExternal(p, newEntry);
            rebalanceInsert(p); // hook for balanced tree subclasses
            return null;
        } else {
            V old = p.getElement().getValue();
            set(p, newEntry);
            rebalanceAccess(p);
            return old;
        }
    }
    
    public V remove(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        
        if (isExternal(p)) {
            rebalanceAccess(p);
            return null;
        } else {
            V old = p.getElement().getValue();
            if (isInternal(left(p)) && isInternal(right(p))) { // both children are internal
                Position<Entry<K,V>> replacement = treeMax(left(p));
                set(p, replacement.getElement());
                p = replacement;
            }
        }
        
        Position<Entry<K,V>> leaf = (isExternal(left(p)) ? left(p) : right(p));
        Position<Entry<K,V>> sib = sibling(leaf);
        remove(leaf);
        remove(p);
        rebalanceDelete(sib);
        return old;
    }
    
    protected Position<Entry<K, V>> treeMax(Position<Entry<K, V>> p) {
        Position<Entry<K,V>> walk = p;
        while(isInternal(walk))
            walk = right(walk);
        return parent(walk);
    }
    
    public Entry<K, V> lastEntry() {
        if (isEmpty()) return null;
        return treeMax(root()).getElement();
    }
    
    public Entry<K,V> floorEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if (isInternal(p)) return p.getElement();
        
        while (!isRoot(p)) {
            if (p == right(parent(p)))
                return parent(p).getElement();
            else 
                p = parent(p);
        }
        
        return null;
    }
    
    public Entry<K,V> lowerEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        
        if (isInternal(p) && isInternal(left(p)))
            return treeMax(left(p)).getElement();
            
        while (!isRoot(p)) {
            if (p == right(parent(p)))
                return parent(p).getElement();
            else 
                p = parent(p);
        }
        
        return null;
    }
    
    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
        for (Position<Entry<K,V>> p : tree.inorder())
            if (isInternal(p)) buffer.add(p.getElement());
            
        return buffer;
    }
    
    public Iterable<Entry<K,V>> subMap(K fromKey, K toKey) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
        if (compare(fromKey, toKey) < 0)
            subMapRecurse(fromKey, toKey, root(), buffer);
        return buffer;
    }
    
    private void subMapRecurse(K fromKey, K toKey, Position<Entry<K,V>> p,
                                   ArrayList<Entry<K,V>> buffer) {
       if (isInternal(p))       
            if (compare(p.getElement(), fromKey) < 0)
                subMapRecurse(fromKey, toKey, right(p), buffer);
            else {
                subMapRecurse(fromKey, toKey, left(p), buffer);
                if (compare(p.getElement( ), toKey) < 0) {
                    buffer.add(p.getElement( ));
                    subMapRecurse(fromKey, toKey, right(p), buffer);
                }
            }
    }
}