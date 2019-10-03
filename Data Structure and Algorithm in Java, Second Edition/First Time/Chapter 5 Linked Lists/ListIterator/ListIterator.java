class ListIterator
    {
    private Link current; // current link
    private Link previous; // previous link
    private LinkList ourList; // our linked list
    //--------------------------------------------------------------
    public ListIterator(LinkList list) // constructor
        {
        ourList = list;
        reset();
        }
    //--------------------------------------------------------------
    public void reset() // start at ‘first’
        {
        current = ourList.getFirst();
        previous = null;
        }
    //--------------------------------------------------------------
    public boolean atEnd() // true if last link
        { return (current.next==null); }
    //--------------------------------------------------------------
    public void nextLink() // go to next link
        {
        previous = current;
        current = current.next;
        }
    //--------------------------------------------------------------
    public Link getCurrent() // get current link
        { return current; }
    //--------------------------------------------------------------
    public void insertAfter(long dd) // insert after
        { // current link
        Link newLink = new Link(dd);
        
        if( ourList.isEmpty() ) // empty list
            {
            ourList.setFirst(newLink);
            current = newLink;
            }
        else // not empty
            {
            newLink.next = current.next;
            current.next = newLink;
            nextLink(); // point to new link
            }
        }
    //--------------------------------------------------------------
    public void insertBefore(long dd) // insert before
        { // current link
        Link newLink = new Link(dd);
        
        if(previous == null) // beginning of list
            { // (or empty list)
            newLink.next = ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
            }
        else // not beginning
            {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
            }
        }
        //--------------------------------------------------------------
    public long deleteCurrent() // delete item at current
        {
        long value = current.dData;
        
        if(previous == null) // beginning of list
            {
            ourList.setFirst(current.next);
            reset();
            }
        else // not beginning
            {
            previous.next = current.next;
            
            if( atEnd() )
                reset();
            else
                current = current.next;
            }
        return value;
        }
        //--------------------------------------------------------------
    } // end class ListIterator
////////////////////////////////////////////////////////////////