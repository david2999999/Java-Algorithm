package StacksAndQueues;

public class Stack {
    // create a private inner class of Node
    private static class Node {
        public Node above, below;   // the node above and below the node
        public int value;   // the data stored inside the node

        public Node(int value) {
            this.value = value;
        }
    }

    // Stack implementation starts here
    private int capacity;   // the max capacity for the stack
    public Node top, bottom; // a node to keep track of the top and bottom of stack
    public int size = 0;    // initial stack size of 0

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return capacity == size;  // stack is full if the current size is equal to max capacity
    }

    public boolean push(int v) {
        if (size >= capacity) return false; // can not fit anymore nodes

        size++;
        Node n = new Node(v);
        if (size == 1) bottom = n;  // only element inside the stack
        top = n;    // set the node to the top of the stack
        return true;
    }

    public int pop() {
        Node t = top;   // get the node from the top of the stack
        top = top.below;    // set the top node to the node below it
        size--;
        return t.value;
    }

    public boolean isEmpty() {
        return size == 0;   // check if the current size is 0
    }
}

















