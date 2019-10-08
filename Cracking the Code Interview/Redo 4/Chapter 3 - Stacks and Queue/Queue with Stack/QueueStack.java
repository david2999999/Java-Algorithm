public class QueueStack {
    Stack<T> stackNewest, stackOldest;

    public QueueStack() {
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }

    public int size() {
        return stackOldest.size() + stackNewest.size();
    }

    public void add(T value) {
        stackNewest.push(value);
    }

    public void shiftStack() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStack();
        return stackOldest.peek();
    }

    public T remove() {
        shiftStack();
        return stackOldest.pop();
    }
}