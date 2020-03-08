public class PriorityQueue<T extends Comparable<T>> {
    private int heapSize = 0;
    private int heapCapacity = 0;

    private List<T> heap = null;
    private Map<T, TreeSet<Integer>> map = new HashMap<>();

    public PriorityQueue() {
        this(1);
    }

    public PriorityQueue(int sz) {
        heap = new ArrayList<>(sz);
    }

    public PriorityQueue(T[] elems) {
        heapSize = heapCapacity = elems.length;
        heapSize = new ArrayList<>(heapCapacity);

        for (int i = 0; i < heapSize; i++) {
            mapAdd(elems[i], i);
            heap.add(elems[i]);
        }

        for (int i = Math.max(0, heapSize / 2 - 1); i >= 0; i--) {
            sink(i);
        }
    }

    public PriorityQueue(Collection<T> elems) {
        this(elems.size());
        for (T elem: elems) {
            add(elem);
        }
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public void clear() {
        for (int i = 0; i < heapCapacity; i++) {
            heap.set(i, null);
        }

        heapSize = 0;
        map.clear();
    }

    public int size() {
        return heapSize;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return heap.get(0);
    }

    public T poll() {
        return removeAt(0);
    }

    public boolean contains(T elem) {
        if (elem == null) {
            return false;
        }

        return map.containsKey(elem);
    }

    public void add(T elem) {
        if (elem == null) {
            throw new IllegalArgumentException();
        }

        if (heapSize < heapCapacity) {
            heap.set(heapSize, elem);
        } else {
            heap.add(elem);
            heapCapacity++;
        }

        mapAdd(elem, heapSize);

        swim(heapSize);
        heapSize++;
    }

    private boolean less(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);

        return node1.compareTo(node2) <= 0;
    }

    private void swap(int i, int j) {
        T iElem = heap.get(i);
        T jElem = heap.get(j);

        heap.set(i, jElem);
        heap.set(j, iElem);

        mapSwap(iElem, jElem, i, j);
    }

    public boolean remove(T element) {
        if (element == null) {
            return false;
        }

        Integer index = mapGet(element);
        if (index != null) {
            removeAt(index);
        }

        return index != null;
    }

    private T removeAt(int i) {
        if (isEmpty()) {
            return null;
        }

        heapSize--;
        T removedData = heap.get(i);
        swap(i, heapSize);

        heap.set(heapSize, null);
        mapRemove(removedData, heapSize);

        if (i == heapSize) {
            return removedData;
        }

        T elem = heap.get(i);
        sink(i);

        if (heapSize.get(i).equals(elem)) {
            swim(i);
        }
    }
}