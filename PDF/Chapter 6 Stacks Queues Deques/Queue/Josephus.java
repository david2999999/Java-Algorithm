public class Josephus {
    public static <E> E Josephus(CircularQueue<E> queue, int k) {
        if (queue.isEmpty()) return null;
        
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) 
                queue.rotate();
            
            E e = queue.dequeue();
        } 
        
        return queue.dequeue();
    }
}