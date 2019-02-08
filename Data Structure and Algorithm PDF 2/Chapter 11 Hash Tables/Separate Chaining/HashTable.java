class HashTable
    {
    private SortedList[] hashArray; // array of lists
    private int arraySize;
    // -------------------------------------------------------------
    public HashTable(int size) // constructor
        {
        arraySize = size;
        hashArray = new SortedList[arraySize]; // create array
        for(int j=0; j<arraySize; j++) // fill array
            hashArray[j] = new SortedList(); // with lists
        }
    // -------------------------------------------------------------
    public void displayTable()
        {
        for(int j=0; j<arraySize; j++) // for each cell,
            {
            System.out.print(j + “. “); // display cell number
            hashArray[j].displayList(); // display list
            }
        }
    // -------------------------------------------------------------
    public int hashFunc(int key) // hash function
        {
        return key % arraySize;
        }
    // -------------------------------------------------------------
    public void insert(Link theLink) // insert a link
        {
        int key = theLink.getKey();
        int hashVal = hashFunc(key); // hash the key
        hashArray[hashVal].insert(theLink); // insert at hashVal
        } // end insert()
    // -------------------------------------------------------------
    public void delete(int key) // delete a link
        {
        int hashVal = hashFunc(key); // hash the key
        hashArray[hashVal].delete(key); // delete link
        } // end delete()
    // -------------------------------------------------------------
    public Link find(int key) // find link
        {
        int hashVal = hashFunc(key); // hash the key
        Link theLink = hashArray[hashVal].find(key); // get link
        return theLink; // return link
        }
    // -------------------------------------------------------------
    } // end class HashTable
    ////////////////////////////////////////////////////////////////