package Redo.StackAndQueue;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value) {
        int min = Math.min(value, min());

        super.push(new NodeWithMin(min, value));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }


}
