package Heap;

public class PriorityQueue {
    public static void main(String[] args) {
        java.util.PriorityQueue<Integer> priorityQueue = new java.util.PriorityQueue<>();

        priorityQueue.add(25);
        priorityQueue.add(-22);
        priorityQueue.add(1343);
        priorityQueue.add(0);
        priorityQueue.add(-3492);
        priorityQueue.add(429);

        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.peek());
    }
}
