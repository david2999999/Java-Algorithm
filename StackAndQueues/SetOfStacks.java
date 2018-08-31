package StackAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
    private ArrayList<Stack> stacks = new ArrayList<>();
    public int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public void push(int value) {
        Stack last = getLastStack();
        // this if statement should also check if the stack is full
        if (last != null && !last.isFull()) {
            last.push(value);
        } else {
            Stack newStack = new Stack(capacity);
            newStack.push(value);
            stacks.add(newStack);
        }
    }


    public int pop() {
        Stack last = getLastStack();

        // this should throw an exception instead
        if (last == null) throw new EmptyStackException();

        int v = last.pop();
        if (last.size == 0) {
            this.stacks.remove(stacks.size() - 1);
        }

        return v;
    }


    private Stack getLastStack() {
        if (this.stacks.size() == 0) return null;

        return this.stacks.get(stacks.size() - 1);
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    private int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removedItem;

        if (removeTop) {
            removedItem = stack.pop();
        }else {
            removedItem = stack.removeBottom();
        }

        if (stack.size == 0) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }

        return removedItem;
    }

    public class Stack {
        private int capacity;
        public Node top, bottom;
        public int size = 0;

        public Stack(int capacity) {
            this.capacity = capacity;
        }

        public boolean isFull() {
            return this.capacity == size;
        }

        public void join(Node above, Node below) {
            if (below != null) below.above = above;
            if (above != null) above.below = below;
        }

        public boolean push(int v) {
            if (size >= capacity) return false;
            size++;
            Node n = new Node(v);
            if (size == 1) bottom = n;
            join(n, top);
            top = n;
            return true;
        }

        public int pop() {
            Node t = top;
            top = top.below;
            size--;
            return top.v;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public int removeBottom() {
            Node b = bottom;
            bottom = bottom.above;
            if (bottom != null) {
                bottom.below = null;
            }
            size--;
            return b.v;
        }

        private class Node {
            public int v;
            public Node above;
            public Node below;

            public Node(int v) {
                this.v = v;
            }
        }
    }
}
