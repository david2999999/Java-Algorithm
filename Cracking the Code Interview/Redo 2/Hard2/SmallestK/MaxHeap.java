package Hard2.SmallestK;

import java.util.Comparator;
import java.util.PriorityQueue;

// Design an algorithm to find the smallest K numbers in an array
public class MaxHeap {
    // in this example, we will use max heap to find the smallest K numbers
    // note: max heap always have the largest element at the root

    // this comparator will make sure that the priority queue is in descending order
    // where the largest element will be at the front of the list
    private static class MaxHeapComparator implements Comparator<Integer> {
        public int compare(Integer x, Integer y) {
            return y - x;
        }
    }

    public int[] smallestK(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Integer> heap = getKMaxHeap(array, k);
        return heapToIntArray(heap);    // converting heap to array
    }

    private int[] heapToIntArray(PriorityQueue<Integer> heap) {
        if (heap == null) return null;

        int[] array = new int[heap.size()]; // array to store all the elements
        while (!heap.isEmpty()) {
            array[heap.size() - 1] = heap.poll();   // insert the elements in ascending order
        }
        return array;
    }

    // generate the heap with the smallest k elements
    private PriorityQueue<Integer> getKMaxHeap(int[] array, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new MaxHeapComparator());

        for (int a: array) {
            if (heap.size() < k) {  // if there are still less than k elements
                heap.add(a);    // add the integer
            } else if (a < heap.peek()){
                // if there are k elements inside the heap
                // and also if the current element is smaller than the largest element in the heap
                heap.poll();    // remove largest element from heap
                heap.add(a);    // insert new element
            }
        }

        return heap;    // return heap with the smallest k elements
    }
}
















