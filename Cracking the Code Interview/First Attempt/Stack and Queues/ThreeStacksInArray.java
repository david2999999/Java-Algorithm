package StackAndQueues;

import java.util.EmptyStackException;

public class ThreeStacksInArray {
    public static void main(String[] args) {

    }

    private static class FixedMultiStack {
        private int numberOfStacks = 3;
        private int stackCapacity;
        private int[] values;
        private int[] sizes;

        public FixedMultiStack(int stackCapacity) {
            this.stackCapacity = stackCapacity;
            values = new int[stackCapacity * numberOfStacks];
            sizes = new int[numberOfStacks];
        }

        public void push(int stackNum, int value) {
            if (isFull(stackNum)) return;

            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }

        public int pop(int stackNum){
            if (isEmpty(stackNum)) throw new EmptyStackException();

            int top = indexOfTop(stackNum);
            int value = values[top];

            sizes[stackNum]--;
            values[top] = 0;

            return value;
        }

        private boolean isEmpty(int stackNum) {
            return sizes[stackNum] == 0;
        }

        private int indexOfTop(int stackNum) {
            int offset = stackCapacity * stackNum;
            return offset + sizes[stackNum] - 1;
        }

        private boolean isFull(int stackNum) {
            return sizes[stackNum] == stackCapacity;
        }
    }
}
