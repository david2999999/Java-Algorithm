public class LinkedList {
    private Node start;

    public void insert(int x) {
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

    public void delete(int x) {
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

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}