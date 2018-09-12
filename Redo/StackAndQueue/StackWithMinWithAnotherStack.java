package Redo.StackAndQueue;

import java.util.Stack;

public class StackWithMinWithAnotherStack extends Stack<Integer> {
    private Stack<Integer> minStack;

    public StackWithMinWithAnotherStack() {
        this.minStack = new Stack<>();
    }

    public void push(int value) {
        if (value <= min()) {
            minStack.push(value);
        }

        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();

        if (value == min()) {
            minStack.pop();
        }

        return value;
    }

    public int min() {
        if (this.minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }
    }
}
