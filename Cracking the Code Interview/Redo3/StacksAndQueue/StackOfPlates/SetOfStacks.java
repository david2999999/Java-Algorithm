package StacksAndQueue.StackOfPlates;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
    private ArrayList<Stack> stacks = new ArrayList<>();
    public int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack() {
        if (stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }

    public void push(int val) {
        Stack last = getLastStack();

        if (last != null && !last.isFull()) {
            last.push(val);
        } else {
            Stack stack = new Stack(capacity);
            stack.push(val);
            stacks.add(stack);
        }
    }

    public int pop() {
        Stack last = getLastStack();
        if (last == null) throw new EmptyStackException();

        int val = last.pop();
        if (last.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }

        return val;
    }

    public boolean isEmpty() {
        Stack last = getLastStack();

        return last == null || last.isEmpty();
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    private int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removed_item;

        if (removeTop) {
            removed_item = stack.pop();
        } else {
            removed_item = stack.removeBottom();
        }

        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }

        return removed_item;
    }
}



















