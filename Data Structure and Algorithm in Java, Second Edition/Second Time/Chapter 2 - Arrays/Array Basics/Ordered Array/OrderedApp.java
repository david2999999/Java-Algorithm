public static void main(String[] args)
{
    int maxSize = 10; // array size
    OrderedArray arr; // reference to array
    arr = new OrderedArray(maxSize); // create the array
    arr.insert(77); // insert 10 items
    arr.insert(99);
    arr.insert(44);
    arr.insert(55);
    arr.insert(22);
    arr.insert(88);
    arr.insert(11);
    arr.insert(00);
    arr.insert(66);
    arr.insert(33);

    arr.display(); // display items
    arr.delete(00); // delete 3 items
    arr.delete(55);
    arr.delete(99);
    arr.display(); // display items again
} // end main()