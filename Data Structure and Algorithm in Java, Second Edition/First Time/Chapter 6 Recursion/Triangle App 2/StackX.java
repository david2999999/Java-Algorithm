import java.io.*; // for I/O
////////////////////////////////////////////////////////////////
class StackX
    {
    private int maxSize; // size of stack array
    private int[] stackArray;
    private int top; // top of stack
    //--------------------------------------------------------------
    public StackX(int s) // constructor
        {
        maxSize = s;
        stackArray = new int[maxSize];
        top = -1;
        }
    //--------------------------------------------------------------
    public void push(int p) // put item on top of stack
        { stackArray[++top] = p; }
    //--------------------------------------------------------------
    public int pop() // take item from top of stack
        { return stackArray[top--]; }
    //--------------------------------------------------------------
    public int peek() // peek at top of stack
        { return stackArray[top]; }
    //--------------------------------------------------------------
    public boolean isEmpty() // true if stack is empty
        { return (top == -1); }
    //--------------------------------------------------------------
    } // end class StackX
////////////////////////////////////////////////////////////////