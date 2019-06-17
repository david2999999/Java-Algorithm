package Hard.SmallestKNumbers;

import javafx.scene.control.ProgressBar;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestKHeap {

    public int[] smallestK(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Integer> heap = getKMaxHeap(array, k);
        return heapToIntArray(heap);
    }


    private PriorityQueue<Integer> getKMaxHeap(int[] array, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k , new MaxHeapComparator());

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

    private int[] heapToIntArray(PriorityQueue<Integer> heap) {
        int[] array = new int[heap.size()];

        while (!heap.isEmpty()) {
            array[heap.size() - 1] = heap.poll();
        }

        return array;
    }


    private class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }


}
