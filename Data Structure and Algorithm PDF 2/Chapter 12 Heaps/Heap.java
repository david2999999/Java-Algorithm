class Heap
    {
    private Node[] heapArray;
    private int maxSize; // size of array
    private int currentSize; // number of nodes in array
    // -------------------------------------------------------------
    public Heap(int mx) // constructor
        {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize]; // create array
        }
    // -------------------------------------------------------------
    public boolean isEmpty()
        { return currentSize==0; }
    // -------------------------------------------------------------
    public boolean insert(int key)
        {
        if(currentSize==maxSize)
            return false;
            
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
        } // end insert()
    // -------------------------------------------------------------
    public void trickleUp(int index)
        {
        int parent = (index-1) / 2;
        Node bottom = heapArray[index];
        while( index > 0 &&
                heapArray[parent].getKey() < bottom.getKey() )
            {
            heapArray[index] = heapArray[parent]; // move it down
            index = parent;
            parent = (parent-1) / 2;
            } // end while
        heapArray[index] = bottom;
        } // end trickleUp()
    // -------------------------------------------------------------
    }