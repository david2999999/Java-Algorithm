class HashTable
    {
    private DataItem[] hashArray; // array holds hash table
    private int arraySize;
    private DataItem nonItem; // for deleted items
    // -------------------------------------------------------------
    public HashTable(int size) // constructor
        {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1); // deleted item key is -1
        }
    // -------------------------------------------------------------
    public void displayTable()
        {
        System.out.print(“Table: “);
        for(int j=0; j<arraySize; j++)
            {
            if(hashArray[j] != null)
            System.out.print(hashArray[j].getKey() + “ “);
            else
            System.out.print(“** “);
            }
        System.out.println(“”);
        }
    // -------------------------------------------------------------
    public int hashFunc(int key)
        {
        return key % arraySize; // hash function
        }
        
        // -------------------------------------------------------------
    public int hashFunc2(int key)
        {
        // non-zero, less than array size, different from hF1
        // array size must be relatively prime to 5, 4, 3, and 2
        return 5 - key % 5;
        }
        // -------------------------------------------------------------
    public void insert(int key, DataItem item)
    // (assumes table not full)
        {
        int hashVal = hashFunc1(key); // hash the key
        int stepSize = hashFunc2(key); // get step size
        // until empty cell or -1
        while(hashArray[hashVal] != null &&
                hashArray[hashVal].getKey() != -1)
            {
            hashVal += stepSize; // add the step
            hashVal %= arraySize; // for wraparound
            }
        hashArray[hashVal] = item; // insert item
        } // end insert()
    // -------------------------------------------------------------
    }