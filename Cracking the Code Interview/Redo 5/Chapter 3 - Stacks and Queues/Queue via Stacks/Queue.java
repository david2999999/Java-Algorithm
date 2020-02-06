public class MyQueue<E> {
    Stack<E> stackNewest, stackOldest;

    public MyQueue() {
        this.stackNewest = new Stack<>();
        this.stackOldest = new Stack<>();
    }

    public int size() {
        return stackOldest.size() + stackNewest.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T value) {
        stackNewest.push(value);
    }

    public T poll() {
        shiftNewestToOldest();
        return stackOldest.pop();
    }

    public T peek() {
        shiftNewestToOldest();
        return stackOldest.peek();
    }

    private void shiftNewestToOldest() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }
}