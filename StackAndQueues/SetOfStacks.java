package StackAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class SetOfStacks {
    private ArrayList<Stack<Integer>> stacks = new ArrayList<>();

    public void push(int value) {
        Stack<Integer> last = getLastStack();
        // this if statement should also check if the stack is full
        if (last != null) {
            last.push(value);
        } else {
            Stack<Integer> newStack = new Stack<>();
            newStack.push(value);
            stacks.add(newStack);
        }
    }


    public int pop() {
        Stack<Integer> last = getLastStack();

        // this should throw an exception instead
        if (last == null) throw new EmptyStackException();

        int v = last.pop();
        if (last.size() == 0) {
            this.stacks.remove(stacks.size() - 1);
        }

        return v;
    }


    private Stack<Integer> getLastStack() {
        if (this.stacks.size() == 0) return null;

        return this.stacks.get(stacks.size() - 1);
    }
}
