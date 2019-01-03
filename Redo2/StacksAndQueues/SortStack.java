package StacksAndQueues;

import java.util.Stack;

// write a function to sort a stack such that the smallest element is at the top
// you are only allowed to use an additional temporary stack
public class SortStack {
    public void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();   // temporary stack to hold values

        while (!s.isEmpty()) {
            // insert elements from s into r in sorted order
            int temp = s.pop();

            while (!r.isEmpty() && r.peek() > temp) {   // removing all elements from r that is bigger than
                s.push(r.pop());                        // the temporary element. Add the bigger elements
            }                                           // back into s stack for now.

            r.push(temp);   // add the temp element after all bigger element inside r is removed
        }

        // since the elements inside stack r are ordered from largest -> smallest
        while (!r.empty()) {
            s.push(r.pop());    // s will not contain elements that are ordered smallest -> largest
        }                       // where the smallest element is at the top of s stack.
    }
}
