public ListElement<Integer> find( ListElement<Integer> head, int data ){
    ListElement<Integer> elem = head;
    while ( elem != null && elem.value() != data ){
        elem = elem.next();
    }
    return elem;
}

// With this implementation, the caller must detect an error condition by checking for a null return
//value. (Alternatively, it may make more sense to throw an exception if the end of the list is reached
//and the element cannot be found.)