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
            rebalanceInsert(position);
            return null;
        } else {
            V old = position.getElement().getValue();
            set(position, newEntry);
            rebalanceAccess(position);
            return old;
        }
    }

    public V remove(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> position = treeSearch(root(), key);

        if (isExternal(position)) {
            rebalanceAccess(position);
            return null;
        } else {
            V old = position.getElement().getValue();
            if (isInternal(left(position)) && isInternal(right(position))) {
                Position<Entry<K, V>> replacement = treeMax(left(p));
                set(position, replacement.getElement());
                position = replacement;
            }

            Position<Entry<K, V>> leaf = (isExternal(left(position)) ? left(position) : right(position));
            Position<Entry<K, V>> sibling = sibling(leaf);
            remove(leaf);
            remove(position);
            rebalanceDelete(sibling);
            return old;
        }
    }

    protected Position<Entry<K, V>> treeMax(Position<Entry<K, V>> p) {
        Position<Entry<K, V>> walk = p;

        while (isInternal(walk)) {
            walk = walk.right;
        }

        return parent(walk);
    }

    public Entry<K, V> lastEntry() {
        if (isEmpty()) return null;
        return treeMax(root()).getElement();
    }

    public Entry<K, V> floorEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> position = treeSearch(root(), key);

        if (isInternal(position)) {
            return position.getElement();
        }

        while (!isRoot(position)) {
            if (position == right(parent(position))) {
                return parent(position).getElement();
            } else {
                position = parent(position);
            }
        }

        return null;
    }

    public Entry<K, V> lowerEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> position = treeSearch(root(), key);

        if (isInternal(position) && isInternal(left(position))) {
            return treeMax(left(position)).getElement();
        }

        while (!isRoot(position)) {
            if (position == right(parent(position))) {
                return parent(position).getElement();
            } else {
                position = parent(position);
            }
        }

        return null;
    }

    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());

        for (Position<Entry<K, V>> position: tree.inOrder()) {
            if (isInternal(position)) {
                buffer.add(position.getElement());
            }
        }

        return buffer;
    }

    public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
        if (compare(fromKey, toKey) < 0) {
            subMapRecurse(fromKey, toKey, root(), buffer);
        }

        return buffer;
    }

    private void subMapRecurse(K fromKey, K toKey, Position<Entry<K, V>> position,
                               ArrayList<Entry<K, V>> buffer) {
        if (isInternal(position)) {
            if (compare(position.getElement(), fromKey) < 0) {
                subMapRecurse(fromKey, toKey, right(p), buffer);
            } else {
                subMapRecurse(fromKey, toKey, left(p), buffer);
                if (compare(position.getElement(), toKey) < 0) {
                    buffer.add(position.getElement());
                    subMapRecurse(fromKey, toKey, right(position), buffer);
                }
            }
        }
    }

    protected void rebalanceInsert(Position<Entry<K,V>> p) { }
    protected void rebalanceDelete(Position<Entry<K,V>> p) { }
    protected void rebalanceAccess(Position<Entry<K,V>> p) { }
}











