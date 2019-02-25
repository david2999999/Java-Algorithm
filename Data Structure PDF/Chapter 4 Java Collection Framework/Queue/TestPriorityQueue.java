public class TestPriorityQueue {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<String>();
        Collections.addAll(queue, "CO", "UY", "EC", "AR");
        System.out.printf("Removed %s%n", queue.remove());
        System.out.printf("Removed %s%n", queue.remove());
        queue.add("PE");
        queue.add("BO");
        System.out.printf("Removed %s%n", queue.remove());
        System.out.printf("Removed %s%n", queue.remove());
    }
}