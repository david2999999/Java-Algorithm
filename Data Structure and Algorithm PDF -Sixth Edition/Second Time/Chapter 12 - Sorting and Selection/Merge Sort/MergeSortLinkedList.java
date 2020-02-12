public class MergeSortLinkedList {
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