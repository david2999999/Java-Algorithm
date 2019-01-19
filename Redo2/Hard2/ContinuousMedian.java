package Hard2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedian {
    Comparator<Integer> maxHeapComparator, minHeapComparator;
    PriorityQueue<Integer> maxHeap, minHeap;

    public void addNewNumber(int randomNumber) {
        // if both of the heaps are the same size
        // we will want to add the random number on the left side, the max heap
        if (maxHeap.size() == minHeap.size()) {
            // if the random number needs to be on the right side, the min heap
            if ((minHeap.peek() != null) && (randomNumber > minHeap.peek())) {
                // move an element from the right side to the left side
                maxHeap.offer(minHeap.poll());
                // add the random number to the right side
                minHeap.offer(randomNumber);
            } else {
                // add the element to the left side
                maxHeap.offer(randomNumber);
            }
        } else {
            // if the size of max heap is greater than the min heap,
            // we would want to move the random element to the right side

            // if the random number needs to be on the left side
            if (randomNumber < maxHeap.peek()) {
                // move an element from the left side to the right side
                minHeap.offer(maxHeap.poll());
                // add the random element to the left side
                maxHeap.offer(randomNumber);
            } else {
                // add the random number to the right side
                minHeap.offer(randomNumber);
            }
        }
    }

    public double getMedian() {
        // since the size of the maxheap always have to be equal to greater than the size
        // of the minheap, if the maxheap has 0 elements, then the min heap also has 0 elements
        if (maxHeap.isEmpty()) {
            return 0;
        }

        if (maxHeap.size() == minHeap.size()) {
            // return the average of the top elements of each heap
            return ((double)minHeap.peek()+(double)maxHeap.peek()) / 2;
        } else {
            // if there an odd number of elements, the top of the max heap will be the median
            return maxHeap.peek();
        }
    }
}















