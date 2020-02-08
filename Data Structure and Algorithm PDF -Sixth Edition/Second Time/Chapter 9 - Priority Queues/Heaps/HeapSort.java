public class HeapSort {
    public static <E> void sort(PositionalList<E> list, PriorityQueue<E, ?> queue) {
        int length = list.size();

        for (int i = 0; i < length; i++) {
            E element = list.remove(list.first());
            queue.insert(element, null);
        }

        for (int i = 0; i < length; i++) {
            E element = queue.removeMin().getKey();
            list.addLast(element);
        }
    }
}