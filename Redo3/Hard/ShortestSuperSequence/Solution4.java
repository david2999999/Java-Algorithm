package Hard.ShortestSuperSequence;

import java.util.*;

public class Solution4 {
    private Range shortestSupersequence(int[] array, int[] elements) {
        ArrayList<Queue<Integer>> locations = getLocationsForElements(array, elements);
        if (locations == null) return null;
        return getShortestClosure(locations);
    }

    private Range getShortestClosure(ArrayList<Queue<Integer>> lists) {
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < lists.size(); i++) {
            int head = lists.get(i).remove();
            minHeap.add(new HeapNode(head, i));
            max = Math.max(max, head);
        }

        int min = minHeap.peek().locationWithinList;
        int bestRangeMin = min;
        int bestRangeMax = max;

        while (true) {
            HeapNode n = minHeap.poll();
            Queue<Integer> list = lists.get(n.listNumber);

            min = n.locationWithinList;
            if (max - min < bestRangeMax - bestRangeMin) {
                bestRangeMax = max;
                bestRangeMin = min;
            }

            if (list.size() == 0) break;

            n.locationWithinList = list.remove();
            minHeap.add(n);
            max = Math.max(max, n.locationWithinList);
        }

        return new Range(bestRangeMin, bestRangeMax);
    }

    private ArrayList<Queue<Integer>> getLocationsForElements(int[] big, int[] small) {
        HashMap<Integer, Queue<Integer>> itemLocations = new HashMap<>();
        for (int s: small) {
            Queue<Integer> queue = new LinkedList<>();
            itemLocations.put(s, queue);
        }

        for (int i = 0; i < big.length; i++) {
            Queue<Integer> queue = itemLocations.get(big[i]);
            if (queue != null) {
                queue.add(i);
            }
        }

        ArrayList<Queue<Integer>> allLocations = new ArrayList<>();
        allLocations.addAll(itemLocations.values());
        return allLocations;
    }
}
