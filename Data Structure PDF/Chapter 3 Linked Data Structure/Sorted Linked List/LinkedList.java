public class LinkedList {
    private Node start;
    
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
    
    
    Node delete(Node start, int x) {
        // precondition: the list is in ascending order;
        // postconditions: the list is in ascending order, and if it did
        // contains x, then the first occurrence of x has been deleted;
        if (start == null || start.data > x) { // x is not in the list
            return start;
        } else if (start.data == x) { // x is the first element in the list
            return start.next;
        }
        
        for (Node p = start; p.next != null; p = p.next) {
            if (p.next.data > x) {
                break; // x is not in the list
            } else if (p.next.data == x) { // x is in the p.next node
                p.next = p.next.next; // delete it
                break;
            }
        }
        return start;
    }
    
    int size() {
        Node current = start;
        int count = 0;
        
        while (current != null) {
            ++count;
            current = current.next;
        }
        
        return count;
    }
    
    int sum() {
        int sum = 0;
        Node current = start;
         
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        
        return sum;
    }
    
    void removeLast(Node list) {
        if (list == null || list.next == null) {
            throw new IllegalStateException();
        }
        
        while (list.next.next != null) {
            list = list.next;
        }
        
        list.next = null;
    }
    
    Node copy(Node list) {
        if (list == null) {
            return null;
        }
        
        Node clone = new Node(list.data);
        
        for (Node p=list, q=clone; p.next != null; p=p.next, q=q.next) {
            q.next = new Node(p.next.data);
        }
        return clone;
    }
    
    Node sublist(Node list, int m, int n) {
        if (m < 0 || n < m) {
            throw new IllegalArgumentException();
        } else if (n == m) {
            return null;
        }
        
        for (int i=0; i<m; i++) {
            list = list.next;
        }
        
        Node clone = new Node(list.data);
        Node p=list, q=clone;
        for (int i=m+1; i<n; i++) {
            if (p.next == null) {
                throw new IllegalArgumentException();
            }
            
            q.next = new Node(p.next.data);
            p = p.next;
            q = q.next;
        }
        return clone;
    }
    
    void append(Node list1, Node list2) {
        if (list1 == null) {
            throw new IllegalStateException();
        }
        
        while (list1.next != null) {
            list1 = list1.next;
        }
        list1.next = list2;
    }
    
    void set(Node list, int i, int x) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        
        for (int j=0; j<i; j++) {
            if (list == null) {
                throw new IllegalStateException();
            }
            list = list.next;
        }
        list.data = x;
        return;
    }
    
    int void get(Node list, int i) {
        // returns the value of element number i;
        Node p = list;
        int j = 0;
        
        while (j < i && p != null) {
            ++j;
            p = p.next;
        }
        
        if (p == null) {
            throw new java.util.NoSuchElementException();
        }
        return p.data;
    }
    
    void put(Node list, int i, int x) {
        // inserts x as element number i;
        if (list == null) {
            throw new java.util.NoSuchElementException("list is empty");
        } else if (i == 0) {
            list.next = new Node(list.data, list.next);
            list.data = x;
        } else {
            Node p = list;
            int j = 1;
            
            while (j < i && p != null) {
                ++j;
                p = p.next;
            }
            if (p == null) {
                String error=String.format("the list has onlt %d elements",j-1);
                throw new java.util.NoSuchElementException(error);
            }
        p.next = new Node(x, p.next);
        }
    }
}