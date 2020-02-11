public class AVLTreeMap<K, V> extends TreeMap<K, V> {
    public AVLTreeMap() {
        super();
    }

    public AVLTreeMap(Comparator<K> comp) {
        super(comp);
    }

    protected int height(Position<Entry<K, V>> p) {
        return tree.getAux(p);
    }

    protected void recomputeHeight(Position<Entry<K, V>> p) {
        tree.setAux(p, 1 + Math.max(height(left(p)), height(right(p))));
    }

    protected boolean isBalanced(Position<Entry<K, V>> p) {
        return Math.abs(height(left(p)) - height(right(p))) <= 1;
    }

    protected Position<Entry<K, V>> tallerChild(Position<Entry<K, V>> p) {
        if (height(left(p)) > height(right(p))) return left(p);
        if (height(left(p)) < height(right(p))) return right(p);

        if (isRoot(p)) return left(p);
        if (p == left(parent(p))) {
            return left(p);
        } else {
            return right(p);
        }
    }

    protected void rebalance(Position<Entry<K, V>> p) {
        int oldHeight, newHeight;

        do {
            oldHeight = height(p);
            if (!isBalanced(p)) {
                p = restructure(tallerChild(tallerChild(p)));
                recomputeHeight(left(p));
                recomputeHeight(right(p));
            }

            recomputeHeight(p);
            newHeight = height(p);
            p = parent(p);
        } while (oldHeight != newHeight && p != null);
    }

    protected void rebalanceInsert(Position<Entry<K, V>> p) {
        rebalance(p);
    }

    protected void rebalanceDelete(Position<Entry<K, V>> p) {
        if (!isRoot(p)) {
            rebalance(parent(p));
        }
    }
}