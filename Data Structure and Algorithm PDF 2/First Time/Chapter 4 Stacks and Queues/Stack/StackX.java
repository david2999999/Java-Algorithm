class StackX
    {
    private int maxSize; // size of stack array
    private long[] stackArray;
    private int top; // top of stack
    //--------------------------------------------------------------
    public StackX(int s) // constructor
        {
        maxSize = s; // set array size
        stackArray = new long[maxSize]; // create array
        top = -1; // no items yet
        }
    //--------------------------------------------------------------
    public void push(long j) // put item on top of stack
        {
        stackArray[++top] = j; // increment top, insert item
        }
    //--------------------------------------------------------------
    public long pop() // take item from top of stack
        {
        return stackArray[top--]; // access item, decrement top
        }
    //--------------------------------------------------------------
    public long peek() // peek at top of stack
        {
        return stackArray[top];
        }
    //--------------------------------------------------------------
    public boolean isEmpty() // true if stack is empty
        {
        return (top == -1);
        }
    //--------------------------------------------------------------
    public int size() // return size
        { return top+1; }
    //--------------------------------------------------------------
    public char peekN(int n) // return item at index n
        { return stackArray[n]; }
    //--------------------------------------------------------------
    public boolean isFull() // true if stack is full
        {
        return (top == maxSize-1);
        }
    //--------------------------------------------------------------
    public void displayStack(String s)
        {
        System.out.print(s);
        System.out.print(“Stack (bottom-->top): “);
            
        for(int j=0; j<size(); j++)
            {
            System.out.print( peekN(j) );
            System.out.print(‘ ‘);
            }
        
        System.out.println(“”);
        }
    } // end class StackX