public class TreeMap<K, V> extends AbstractSortedMap<K, V> {
    protected BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree<>();

    public TreeMap() {
        super();
        tree.addRoot(null);
    }

    public TreeMap(Comparator<K> comp) {
        super(comp);
        tree.addRoot(null);
    }

    public int size() {
        return (tree.size() - 1) / 2;
    }

    private void expandExternal(Position<Entry<K, V>> p, Entry<K, V> entry) {
        tree.set(p, entry);
        tree.addLeft(p, null);
        tree.addRight(p, null);
    }

    protected Position<Entry<K, V>> root() {
        return tree.root();
    }

    private Position<Entry<K, V>> treeSearch(Position<Entry<K, V>> p, K key) {
        if (isExternal(p)) {
            return p;
        }

        int comp = compare(key, p.getElement());

        if (comp == 0) {
            return p;
        } else if (comp < 0) {
            return treeSearch(left(p), key);
        } else {
            return treeSearch(right(p), key);
        }
    }

    public V get(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> position = treeSearch(root(), key);
        rebalanceAccess(position);

        if (isExternal(position)) {
            return null;
        }

        return position.getElement().getValue();
    }

    public V put(K key, V value) throw IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newEntry = new MapEntry<>(key, value);
        Position<Entry<K, V>> position = treeSearch(root(), key);

        if (isExternal(position)) {
            expandExternal(position, newEntry);
            rebalanceInsert(p);
            return null;
        } else {
            V old = position.getElement().getValue();
            set(position, newEntry);
            rebalanceAccess(p);
            return old;
        }
    }

    public V remove(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> position = treeSearch(root(), key);

        if (isExternal(position)) {
            rebalanceAccess(p);
            return null;
        } else {
            V old = position.getElement().getValue();
            if (isInternal(left(position)) && isInternal(right(position))) {
                Position<Entry<K, V>> replacement = treeMax(left(p));
                set(position, replacement.getElement());
                position = replacement;
            }

            Position<Entry<K, V>> leaf = (isExternal(left(p)) ? left(p) : right(p));
            Position<Entry<K, V>> sibling = sibling(leaf);
            remove(leaf);
            remove(p);
            rebalanceDelete(sibling);
            return old;
        }

        protected Position<Entry<K, V>> treeMax(Position<Entry<K, V>> p) {
            Position<Entry<K, V>> walk = p;

            while (isInternal(walk)) {
                walk = walk.right;
            }

            return parent(walk);
        }
    }
}