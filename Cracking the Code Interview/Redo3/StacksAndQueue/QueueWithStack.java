package StacksAndQueue;

import java.util.Stack;

public class QueueWithStack<T> {
    Stack<T> stackNewest, stackOldest;

    public QueueWithStack() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
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
