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
    public Node remove() // delete item with max key
        { // (assumes non-empty list)
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
        } // end remove()
        // -------------------------------------------------------------
    public void trickleDown(int index)
        {
        int largerChild;
        Node top = heapArray[index]; // save root
        
        while(index < currentSize/2) // while node has at
            { // least one child,
            int leftChild = 2*index+1;
            int rightChild = leftChild+1;
            // find larger child
            if(rightChild < currentSize && // (rightChild exists?)
                heapArray[leftChild].getKey() <
                heapArray[rightChild].getKey())
                largerChild = rightChild;
            else
                largerChild = leftChild;
                
            // top >= largerChild?
            if( top.getKey() >= heapArray[largerChild].getKey() )
                break;
            // shift child up
            heapArray[index] = heapArray[largerChild];
            index = largerChild; // go down
            } // end while
        heapArray[index] = top; // root to index
        } // end trickleDown()
    }