package StackAndQueues;

import java.util.Stack;

public class StackWithMin {
    public static void main(String[] args) {

    }

    private class StackWithMinimum extends Stack<NodeWithMin> {
        public void push(int value) {
            int minValue = Math.min(value, min());
            super.push(new NodeWithMin(value, minValue));
        }

        private int min() {
            if (this.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return this.peek().min;
            }
        }
    }



    private class NodeWithMin {
        private int value;
        private int min;

        public NodeWithMin(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}
