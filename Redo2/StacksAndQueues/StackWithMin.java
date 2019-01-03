package StacksAndQueues;

import java.util.Stack;

// implement a stack, which in addition to push and pop
// has a min function that returns the minimum element from the stack
public class StackWithMin extends Stack<NodeWithMin> {

    public void push(int value) {
        // comparing the value with the minimum value in the stack
        int newMin = Math.min(value, min());

        // add a new node to the stack with the value
        // and also a new min
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        // isEmpty() method is inherited from Stack superclass
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;   // currently no minimum value, return the highest integer
        } else {
            return peek().min;  // checking the top of the stack for the minimum value
        }
    }

}
