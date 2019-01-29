class LinkList
    {
    private Link first; // ref to first item on list
    // -------------------------------------------------------------
    public LinkList() // constructor
        { first = null; } // no items on list yet
    // -------------------------------------------------------------
    public Link getFirst() // get value of first
        { return first; }
    // -------------------------------------------------------------
    public void setFirst(Link f) // set first to new link
        { first = f; }
    // -------------------------------------------------------------
    public boolean isEmpty() // true if list is empty
        { return first==null; }
    // -------------------------------------------------------------
    public ListIterator getIterator() // return iterator
        {
        return new ListIterator(this); // initialized with
        } // this list
    // -------------------------------------------------------------
    public void displayList()
        {
        Link current = first; // start at beginning of list
        while(current != null) // until end of list,
            {
            current.displayLink(); // print data
            current = current.next; // move to next link
            }
        System.out.println(“”);
        }
    // -------------------------------------------------------------
    } // end class LinkList
////////////////////////////////////////////////////////////////