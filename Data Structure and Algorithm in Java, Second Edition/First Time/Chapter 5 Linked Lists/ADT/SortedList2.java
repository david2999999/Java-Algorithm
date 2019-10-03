class SortedList2
    {
    private Link first; // ref to first item on list
    // -------------------------------------------------------------
    public SortedList() // constructor (no args)
        { first = null; } // initialize list
    // -------------------------------------------------------------
    public SortedList(Link[] linkArr) // constructor (array
        { // as argument)
        first = null; // initialize list
        for(int j=0; j<linkArr.length; j++) // copy array
            insert( linkArr[j] ); // to list
        }
    // -------------------------------------------------------------
    public void insert(Link k) // insert (in order)
        {
        Link previous = null; // start at first
        Link current = first;
        // until end of list,
        while(current != null && k.dData > current.dData)
            { // or key > current,
            previous = current;
            current = current.next; // go to next item
            }
            
        if(previous==null) // at beginning of list
            first = k; // first --> k
        else // not at beginning
            previous.next = k; // old prev --> k
            
        k.next = current; // k --> old current
        } // end insert()
    // -------------------------------------------------------------
    public Link remove() // return & delete first link
        { // (assumes non-empty list)
        Link temp = first; // save first
        first = first.next; // delete first
        return temp; // return value
        }
    // -------------------------------------------------------------
    } // end class SortedList