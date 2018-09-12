package Redo.StackAndQueue;

import java.util.Stack;

public class SortingStackWithAnotherStack {
    private void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();

        while (!s.empty()) {
            int value = s.pop();

            while (!r.empty() && value < r.peek()) {
                s.push(r.pop());
            }

            r.push(value);
        }

        while (!r.empty()) {
            s.push(r.pop());
        }
    }
}
