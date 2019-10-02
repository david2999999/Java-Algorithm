package StackAndQueues;

import java.util.Stack;

public class SortingStack {
    public static void sortStack(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();

        while (!s.empty()) {
            int temp = s.pop();
            while (!r.empty() && r.peek() > temp) {
                s.push(r.pop());
            }
            r.push(temp);
        }

        while (!r.empty()) {
            s.push(r.pop());
        }
    }
}
