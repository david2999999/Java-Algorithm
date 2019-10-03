package Hard.SmallestKth;

import java.util.PriorityQueue;

public class Solution2 {
    private int[] smallest(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Integer> heap = getKMaxHeap(array, k);
        return heapToIntArray(heap);
    }

    private int[] heapToIntArray(PriorityQueue<Integer> heap) {
        int[] array = new int[heap.size()];
        while (!heap.isEmpty()) {
            array[heap.size() - 1] = heap.poll();
        }

        return array;
    }

    private PriorityQueue<Integer> getKMaxHeap(int[] array, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new MaxHeapComparator());
        for (int a: array) {
            if (heap.size() < k) {
                heap.add(a);
            } else if (a < heap.peek()) {
                heap.poll();
                heap.add(a);
            }
        }

        return heap;
    }
}
