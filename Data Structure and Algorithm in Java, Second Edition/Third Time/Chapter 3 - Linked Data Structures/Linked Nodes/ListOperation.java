public class ListOperation {
    public void insert(Node start, int x) {
        if (start == null) {
            start = new Node(x);
            return;
        }

        Node p = start;
        while (p.next != null) {
            if (p.next.data > x) break;
            p = p.next;
        }

        p.next = new Node(x, p.next);
    }
}