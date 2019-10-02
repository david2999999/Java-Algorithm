package StackAndQueues;

import java.util.Stack;

public class QueueWith2Stacks<T> {
    Stack<T> stackNewest, stackOldest;

    public QueueWith2Stacks() {
        this.stackNewest = new Stack<>();
        this.stackOldest = new Stack<>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        stackNewest.push(value);
    }

    private void shiftStacks() {
        if (stackOldest.size() == 0) {
            while (!stackNewest.empty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    private T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    private T remove() {
        shiftStacks();
        return stackOldest.pop();
    }
}
