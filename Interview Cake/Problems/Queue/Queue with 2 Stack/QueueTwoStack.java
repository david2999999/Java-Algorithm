public class QueueTwoStack {
    private Deque<Integer> inStack = new ArrayDeque<>();
    private Deque<Integer> outStack = new ArrayDeque<>();

    public void enqueue(int item) {
        inStack.push(item);
    }

    public int dequeue(int item) {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }

            if (outStack.isEmpty()) {
                throw new NoSuchElementException("Can't dequeue from empty queue!");
            }
        }

        return outStack.pop();
    }
}