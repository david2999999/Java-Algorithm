package StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;

// implement a data structure that is composed of several stacks
// and should create a new stack once the previous one exceeds capacity
// push() and pop() method should behave identically to a single stack
public class StacksOfPlates {
    // we are going to implement our custom Stack class
    ArrayList<Stack> stacks = new ArrayList<>();    // creating a list of stacks
    public int capacity;    // maximum capacity for each stack

    public StacksOfPlates(int capacity) {
        this.capacity = capacity;
    }

    // since Stacks works as LIFO, last in first out
    // we want to work with the stack that is at the end of the list
    public Stack getLastStack() {
        if (stacks.size() == 0) return null;    // there are no stacks from the list
        return stacks.get(stacks.size() - 1);   // get the last stack from the list
    }

    public void push(int v) {
        Stack last = getLastStack();
        if (last != null && !last.isFull()) {   // if the stack exists and is not full
            last.push(v);   // add the value to the stack
        } else {    // need to create a new stack for the list
            Stack stack = new Stack(capacity);  // new stack
            stack.push(v);  // add the value to the new stack
            stacks.add(stack);  // add the new stack to the list
        }
    }

    public int pop() {
        Stack last = getLastStack();
        if (last == null) throw new EmptyStackException();  // no stack exist
        int v = last.pop(); // get the topmost element form the stack

        // if the stack has no more elements, remove it from the list
        if (last.size == 0) stacks.remove(stacks.size() - 1);

        return v;
    }

    // checking if there is a stack in the list
    // also checking if the stack is empty
    public boolean isEmpty() {
        Stack last = getLastStack();
        return last == null || last.isEmpty();
    }
}



















