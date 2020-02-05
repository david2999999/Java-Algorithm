public class Stack<E> {
    private static class Node<E> {
        public E value;
        public Node<E> above, below;

        public Node(E value, Node<E> above, Node<E> below) {
            this.value = value;
            this.above = above;
            this.below = below;
        }
    }

    private Node<E> topSentinel, bottomSentinel;
    private int size = 0;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        topSentinel = new Node<>(null, null, null);
        bottomSentinel = new Node<>(null, topSentinel, null);
        topSentinel.below = bottomSentinel;
    }

    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        Node<E> top = topSentinel.below;
        join(topSentinel, top.below);

        E answer = top.value;
        top = null;
        size--;
        return answer;
    }

    public boolean push(E value) {
        if (isFull()) return false;
        Node<E> newNode = new Node<E>(value, topSentinel, topSentinel.below);
        topSentinel.below.above = newNode;
        topSentinel.below = newNode;
        size++;
        return true;
    }

    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return topSentinel.below.value;
    }

    public E removeBottom() {
        if (isEmpty()) throw new EmptyStackException();
        Node<E> bottom = bottomSentinel.above;
        join(bottom.above, bottomSentinel);

        E value = bottom.value;
        bottom = null;
        size--;
        return value;
    }

    private void join(Node<E> above, Node<E> below) {
        if (above != null) above.below = below;
        if (below != null) below.above = above;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size
    }
}