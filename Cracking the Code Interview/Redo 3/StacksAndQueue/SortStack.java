package StacksAndQueue;

import java.util.Stack;

public class SortStack {
    public void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();

        while (!s.isEmpty()) {
            int temp = s.pop();

            while (!r.isEmpty() && r.peek() > temp) {
                s.push(r.pop());
            }

            r.push(temp);
        }

        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }
}
