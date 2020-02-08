public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    public HeapPriorityQueue() {
        super();
    }

    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    protected int parent(int j) {
        return (j - 1) / 2;
    }

    protected int left(int j) {
        return (2 * j) + 1;
    }

    protected int right(int j) {
        return (2 * j) + 2;
    }

    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    protected void upheap(int currentIndex) {
        while (currentIndex > 0) {
            int parentIndex = parent(currentIndex);
            if (compare(heap.get(currentIndex), heap.get(parentIndex)) > 0) break;
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
    }

    protected void downheap(int currentIndex) {
        while (hasLeft(currentIndex)) {
            int leftIndex = left(currentIndex);
            int smallChildIndex = leftIndex;

            if (hasRight(currentIndex)) {
                int rightIndex = right(currentIndex);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0) {
                    smallChildIndex = rightIndex;
                }
            }

            if (compare(heap.get(smallChildIndex), heap.get(currentIndex)) > 0)
                break;

            swap(currentIndex, smallChildIndex);
            currentIndex = smallChildIndex;
        }
    }

    public int size() {
        return heap.size();
    }

    public Entry<K, V> min() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        heap.add(newest);
        upheap(heap.size() - 1);
        return newest;
    }

    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) return null;
        Entry<K, V> answer = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downheap(0);
        return answer;
    }
}