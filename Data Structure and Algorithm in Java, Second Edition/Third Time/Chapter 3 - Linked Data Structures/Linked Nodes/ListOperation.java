public class ListOperation {
    public Node insert(Node start, int x) {
        if (start == null || start.data > x) {
           return new Node(x, start);
        }

        Node p = start;
        while (p.next != null) {
            if (p.next.data > x) break;
            p = p.next;
        }

        p.next = new Node(x, p.next);
        return start;
    }

    // precondition: the list is in ascending order;
    // postconditions: the list is in ascending order, and if it did
    // contains x, then the first occurrence of x has been deleted;
    public Node delete(Node start, int x) {
        if (start == null || start.data > x) {
            return start;
        } else if (start.data == x) {
            return start.next;
        }

        for (Node p = start; p.next != null; p = p.next) {
            if (p.next.data > x) {
                break;
            } else if (p.next.data == x) {
                p.next = p.next.next;
                break;
            }
        }

        return start;
    }
}