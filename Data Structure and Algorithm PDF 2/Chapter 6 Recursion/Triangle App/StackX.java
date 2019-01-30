class StackX
    {
    private int maxSize; // size of StackX array
    private Params[] stackArray;
    
    private int top; // top of stack
    //--------------------------------------------------------------
    public StackX(int s) // constructor
        {
        maxSize = s; // set array size
        stackArray = new Params[maxSize]; // create array
        top = -1; // no items yet
        }
    //--------------------------------------------------------------
    public void push(Params p) // put item on top of stack
        {
        stackArray[++top] = p; // increment top, insert item
        }
    //--------------------------------------------------------------
    public Params pop() // take item from top of stack
        {
        return stackArray[top--]; // access item, decrement top
        }
    //--------------------------------------------------------------
    public Params peek() // peek at top of stack
        {
        return stackArray[top];
        }
        //--------------------------------------------------------------
    } // end class StackX
////////////////////////////////////////////////////////////////
