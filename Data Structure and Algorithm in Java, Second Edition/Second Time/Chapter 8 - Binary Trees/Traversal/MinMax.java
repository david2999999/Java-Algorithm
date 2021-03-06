public class MinMax {
    public Node minimum() {
        Node current, last;
        current = root;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last;
    }

    public Node maximum() {
        Node current, last;
        current = root;

        while (current != null) {
            last = current;
            current = current.rightChild;
        }

        return last;
    }
}