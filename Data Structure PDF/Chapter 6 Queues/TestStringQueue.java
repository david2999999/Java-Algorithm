 public class TestStringQueue {
     public static void main(String[] args) {
         Queue<String> queue = new ArrayDeque<String>();
         queue.add("GB");
         queue.add("DE");
         queue.add("FR");
         queue.add("ES");
         System.out.println(queue);
         System.out.println("queue.element(): " + queue.element());
         System.out.println("queue.remove(): " + queue.remove());
         System.out.println(queue);
         System.out.println("queue.remove(): " + queue.remove());
         System.out.println(queue);
         System.out.println("queue.add(\"IE\"): ");
         queue.add("IE");
         System.out.println(queue);
         System.out.println("queue.remove(): " + queue.remove());
         System.out.println(queue);
     }
 }