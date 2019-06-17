package StacksAndQueue.StackWithMin;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
    private Stack<Integer> s2;

    public StackWithMin2() {
        s2 = new Stack<>();
    }

    public void push(int value) {
        if (value <= min()) {
            s2.push(value);
        }

        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            s2.pop();
        }

        return value;
    }

    private int min() {
        if (s2.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }
}
