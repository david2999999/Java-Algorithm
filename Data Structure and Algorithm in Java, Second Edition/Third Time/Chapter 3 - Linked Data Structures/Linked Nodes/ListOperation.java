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
}