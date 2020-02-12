public class MergeSortLinkedList {
    public <E> void mergeSort(Queue<K> queue, Comparator<K> comp) {
        int length = queue.size();
        if (length < 2) return;

        Queue<K> buffer1 = new LinkedQueue<>();
        Queue<K> buffer2 = new LinkedQueue<>();

        while (buffer1.size() < length / 2) {
            buffer1.enqueue(queue.dequeue());
        }

        while (!queue.isEmpty()) {
            buffer2.enqueue(queue.dequeue());
        }

        mergeSort(buffer1, comp);
        mergeSort(buffer2, comp);
        merge(buffer1, buffer2, queue, comp);
    }

    public <E> void merge(Queue<K> buffer1, Queue<K> buffer2,
                          Queue<K> queue, Comparator<K> comp) {
        while (!buffer1.isEmpty() && !buffer2.isEmpty()) {
            if (comp.compare(buffer1, buffer2) < 0) {
                queue.enqueue(buffer1.dequeue());
            } else {
                queue.enqueue(buffer2.dequeue());
            }
        }

        while (!buffer1.isEmpty()) {
            queue.enqueue(buffer1.dequeue());
        }

        while (!buffer2.isEmpty()) {
            queue.enqueue(buffer2.dequeue());
        }
    }
}