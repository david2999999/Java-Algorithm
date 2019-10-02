package StackAndQueues;

import java.util.Stack;

public class StackWithMin2 {
    public static void main(String[] args) {

    }

    private class StackWithMinimum extends Stack<Integer> {
        Stack<Integer> s2;

        public StackWithMinimum() {
            s2 = new Stack<>();
        }

        public void push(int value) {
            super.push(value);

            if (value <= min()) {
                s2.push(value);
            }
        }

        public Integer pop() {
            int value = super.pop();

            if (value == min()) {
                s2.pop();
            }

            return value;
        }

        public int min() {
            if (this.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return s2.peek();
            }
        }
    }
}
