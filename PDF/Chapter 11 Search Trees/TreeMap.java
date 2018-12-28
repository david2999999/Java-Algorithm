public class TreeMap<K, V> extends AbstractSortedMap<K, V> {
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
}