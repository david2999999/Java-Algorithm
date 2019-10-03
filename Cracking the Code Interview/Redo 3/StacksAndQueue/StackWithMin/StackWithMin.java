package StacksAndQueue.StackWithMin;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    private int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }
}
