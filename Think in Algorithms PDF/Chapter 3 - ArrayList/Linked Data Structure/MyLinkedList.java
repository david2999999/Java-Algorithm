public class MyLinkedList<E> implements List<E> {
    private int size; // keeps track of the number of elements
    private Node head; // reference to the first node
    
    public MyLinkedList() {
        head = null;
        size = 0;
    }
}