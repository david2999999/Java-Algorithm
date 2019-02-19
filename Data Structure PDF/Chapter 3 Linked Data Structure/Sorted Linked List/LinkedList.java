public class LinkedList {
    
    Node insert(Node start, int x) {
        // precondition: the list is in ascending order;
        // postconditions: the list is in ascending order, and it contains x;
        if (start == null || start.data > x) {
            start = new Node(x,start);
            return start;
        }
        
        Node p=start;
        while (p.next != null) {
            if (p.next.data > x) break;
            p = p.next;
        }
        
        p.next = new Node(x,p.next);
        return start;
    } 
    
    
}