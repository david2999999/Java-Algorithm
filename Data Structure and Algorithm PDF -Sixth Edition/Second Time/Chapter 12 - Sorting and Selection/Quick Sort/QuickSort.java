public class QuickSort {
    public static <E> void sort(Queue<K> queue, Comparator<K> comp) {
        int length = queue.size();
        if (length < 2) return;

        K pivot = queue.first();
        Queue<K> less = new LinkedQueue<>();
        Queue<K> equal = new LinkedQueue<>();
        Queue<K> greater = new LinkedQueue<>();

        while (!queue.isEmpty()) {
            K element = queue.dequeue();
            int comparison = comp.compare(element, pivot);

            if (comparison < 0) {
                less.enqueue(element);
            } else if (comparison == 0) {
                equal.enqueue(element);
            } else {
                greater.enqueue(element);
            }
        }

        quickSort(less, comp);
        quickSort(greater, comp);

        while (!less.isEmpty()) {
            queue.enqueue(less.dequeue());
        }

        while (!equal.isEmpty()) {
            queue.enqueue(equal.dequeue());
        }

        while (!greater.isEmpty()) {
            queue.enqueue(greater.dequeue());
        }
    }
}