package Redo.StackAndQueue;

import java.util.Stack;

public class QueueWith2Stacks<T> {
    private Stack<T> newestStack;
    private Stack<T> oldestStack;

    public QueueWith2Stacks() {
        this.newestStack = new Stack<>();
        this.oldestStack = new Stack<>();
    }

    public void push(T value) {
        newestStack.push(value);
    }

    public int size() {
        return newestStack.size() + oldestStack.size();
    }

    public void shiftStack() {
        if (oldestStack.isEmpty()) {
            while (!newestStack.isEmpty()) {
                oldestStack.push(newestStack.pop());
            }
        }
    }

    public T peek() {
        shiftStack();
        return oldestStack.peek();
    }

    public T remove() {
        shiftStack();
        return oldestStack.pop();
    }
}
