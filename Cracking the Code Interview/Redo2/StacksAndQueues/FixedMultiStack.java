package StacksAndQueues;

import java.util.EmptyStackException;

// implement three stacks with 1 array
public class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;  // the capacity of each stack
    private int[] values;  // the array will contain 3 stacks
                            // each stack takes up 1/3 of values size

    private int[] sizes;    // keeps track of the size of the stacks
                            // index 0 -> current stack size of stack 1
                            // index 1 -> current stack size of stack 2
                            // index 2 -> current stack size of stack 3

    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;  // each stack size
        values = new int[stackSize * numberOfStacks];   // stack size * 3
        sizes = new int[numberOfStacks];    // all 3 sizes initialized to 0
    }

    public void push(int stackNum, int value) throws FullStackException {
        if (isFull(stackNum)) { // check if the specific stack is already full
            throw new FullStackException();
        }

        sizes[stackNum]++;  // increment the specific stack size by 1
        values[indexOfTop(stackNum)] = value;    // push the value onto the top index of the stack
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {    // check if the specific stack is empty
            throw new EmptyStackException();
        }

        int topIndex = indexOfTop(stackNum);    // getting the index of the top of the stack
        int value = values[topIndex];   //  getting the value from the top index
        values[topIndex] = 0;    // clear the value
        sizes[stackNum]--;      // shrink the size of the stack
        return value;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }

        return values[indexOfTop(stackNum)];    // just looking at the top of the stack without removing it
    }

    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }


    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;   // the top index of the stack without a value
    }

    private boolean isFull(int stackNum) {
        // stackCapacity is the maximum size of the stack
        // comparing the size of a specific stack to the stackCapacity
        return sizes[stackNum] == stackCapacity;
    }

    private class FullStackException extends Exception {
    }
}


















