public class Stack {
    private static class Node {
        public int value;
        public Node above, below;

        public Node(int value) {
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    private Node top, bottom;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
        Node t = top;
        top = top.below;
        if (top != null) top.above = null;

        size--;
        if (size == 0) bottom = null;

        return t.value;
    }

    public int removeBottom() {
        if (isEmpty()) throw new EmptyStackException();
        Node b = bottom;
        bottom = bottom.above;
        if (bottom != null) bottom.below = null;

        size--;
        if (size == 0) top = null;

        return b.value;
    }

    public boolean push(int value) {
        if (isFull()) return false;
        size++;

        Node newNode = new Node(value);
        if (size == 1) bottom = newNode;

        join(newNode, top);
        top = newNode;
        return true;
    }

    private void join(Node above, Node below) {
        if (above != null) above.below = below;
        if (below != null) below.above = above;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}