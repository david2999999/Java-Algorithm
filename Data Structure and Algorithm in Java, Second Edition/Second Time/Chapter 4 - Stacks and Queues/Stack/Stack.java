public class Stack {
    private int maxSize; // size of stack array
    private char[] stackArray;
    private int top; // top of stack

    public Stack(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(char j) {
        if (isFull()) throw new FullStackException();

        stackArray[++top] = j; // increment top, insert item
    }

    public char pop() {
        if (isEmpty()) throw new EmptyStackException();

        return stackArray[top--]; // access item, decrement top
    }

    public char peek() {
        if (isEmpty()) throw new EmptyStackException();

        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize-1);
    }
}