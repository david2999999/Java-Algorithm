 public class TestQueue {
     public static void main(String[] args) {
         Queue<String> queue = new LinkedQueue<String>();
         Collections.addAll(queue, "AR", "BO", "CO", "EC");
         System.out.println(queue);
         String firstOut = queue.remove();
         System.out.println(queue);
         System.out.printf("Removed %s%n", firstOut);
         queue.add("PE");
         System.out.println(queue);
         String secondOut = queue.remove();
         System.out.println(queue);
         System.out.printf("Removed %s%n", secondOut);
     }
 }