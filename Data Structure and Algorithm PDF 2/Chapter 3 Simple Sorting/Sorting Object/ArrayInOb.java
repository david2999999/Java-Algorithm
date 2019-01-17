class ArrayInOb
    {
    private Person[] a; // ref to array a
    private int nElems; // number of data items
    //--------------------------------------------------------------
    public ArrayInOb(int max) // constructor
        {
        a = new Person[max]; // create the array
        nElems = 0; // no items yet
        }
    //--------------------------------------------------------------
    // put person into array
    public void insert(String last, String first, int age)
        {
        a[nElems] = new Person(last, first, age);
        nElems++; // increment size
        }
    //--------------------------------------------------------------
    public void display() // displays array contents
        {
        for(int j=0; j<nElems; j++) // for each element,
            a[j].displayPerson(); // display it
        System.out.println(“”);
        }
    //--------------------------------------------------------------
    public void insertionSort()
        {
        int in, out;
        for(out=1; out<nElems; out++) // out is dividing line
            {
            Person temp = a[out]; // remove marked person
            in = out; // start shifting at out
            while(in>0 && // until smaller one found,
                    a[in-1].getLast().compareTo(temp.getLast())>0)
                {
                a[in] = a[in-1]; // shift item to the right
                --in; // go left one position
                }
            a[in] = temp; // insert marked item
            } // end for
        } // end insertionSort()
    //--------------------------------------------------------------
    } // end class ArrayInOb