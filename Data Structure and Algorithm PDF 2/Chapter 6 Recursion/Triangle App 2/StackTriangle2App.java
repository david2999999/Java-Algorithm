class StackTriangle2App
    {
    static int theNumber;
    static int theAnswer;
    static StackX theStack;
    
    public static void main(String[] args) throws IOException
        {
        System.out.print(“Enter a number: “);
        theNumber = getInt();
        stackTriangle();
        System.out.println(“Triangle=”+theAnswer);
        } // end main()
        //-------------------------------------------------------------
    public static void stackTriangle()
        {
        theStack = new StackX(10000); // make a stack
        theAnswer = 0; // initialize answer
        
        while(theNumber > 0) // until n is 1,
            {
            theStack.push(theNumber); // push value
            --theNumber; // decrement value
            }
            
        while( !theStack.isEmpty() ) // until stack empty,
            {
            int newN = theStack.pop(); // pop value,
            theAnswer += newN; // add to answer
            }
    }
    //-------------------------------------------------------------
    public static String getString() throws IOException
        {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
        }
    //-------------------------------------------------------------
    public static int getInt() throws IOException
        {
        String s = getString();
        return Integer.parseInt(s);
        }
    //-------------------------------------------------------------
    } // end class StackTriangle2App