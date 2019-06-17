package StacksAndQueues;

import java.util.Stack;

// implement a stack, which in addition to push and pop
// has a min function that returns the minimum element from the stack
public class StackWithMin2 extends Stack<Integer> {
    // we need a stack class to store all of the min values
    Stack<Integer> s2;

    public StackWithMin2() {
        s2 = new Stack<>();
    }

    public void push(int value) {
        if (value <= min()) {   // if the value is less than or equal to the min on top of the stack
            s2.push(value); // add another minimum value to the min stack
        }

        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();    // removing the top element from the stack
        if (value == min()) {       // if the top element is equal to the min
            s2.pop();               // remove a min from the min stack
        }

        return value;
    }

    public int min() {
        if (s2.isEmpty()) { // there are no minimum values stored in the min stack
            return Integer.MAX_VALUE;   // return the biggest number indicating error
        } else {
            return s2.peek();   // the min value will be stored at the top of the min stack
        }
    }
}
