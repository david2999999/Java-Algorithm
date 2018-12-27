public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();
    
    public HeapPriorityQueue() { super(); }
    public HeapPriorityQueue(Comparator<K> comp) { super(comp); }
    
    protected int parent(int j) { return (j−1) / 2; }
    protected int left(int j) { return 2*j + 1; }
    protected int right(int j) { return 2*j + 2; }
    
    protected boolean hasLeft(int j) { return left(j) < heap.size(); }
    protected boolean hasRight(int j) { return right(j) < heap.size(); }
}