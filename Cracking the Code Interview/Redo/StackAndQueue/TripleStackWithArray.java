package Redo.StackAndQueue;

import java.util.EmptyStackException;

public class TripleStackWithArray {
    private int numberOfStacks = 3;
    private int maxStackSize;
    private int[] sizes;
    private int[] values;

    public TripleStackWithArray(int maxStackSize) {
        this.maxStackSize = maxStackSize;
        values = new int[maxStackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    public void push(int value, int stackNum) throws Exception {
        if (isFull(stackNum)) throw new Exception("Stack is full");

        int topIndex = findTopIndex(stackNum);
        values[topIndex] = value;
        sizes[stackNum]++;
    }

    public int pop(int stackNum){
        if (isEmpty(stackNum)) throw new EmptyStackException();

        int topIndex = findTopIndex(stackNum);
        int value = values[topIndex];

        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    private int peek(int stackNum) {
        if (isEmpty(stackNum)) throw new EmptyStackException();

        int topIndex = findTopIndex(stackNum);
        return values[topIndex];
    }

    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] == maxStackSize;
    }

    private int findTopIndex(int stackNum) {
        int offset = stackNum * maxStackSize;
        int size = sizes[stackNum];
        return offset + size - 1;
    }


}
