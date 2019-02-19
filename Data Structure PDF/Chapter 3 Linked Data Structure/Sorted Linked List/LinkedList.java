public class LinkedList {
    
     void insert(Node start, int x) {
         // PRECONDITIONS: the list is in ascending order, and x > start.data;
         // POSTCONDITIONS: the list is in ascending order, and it contains x;
         Node p = start;
         while (p.next != null) {
             if (p.next.data > x) break;
                p = p.next;
         }
         
         p.next = new Node(x,p.next);
     }    
    
    
}