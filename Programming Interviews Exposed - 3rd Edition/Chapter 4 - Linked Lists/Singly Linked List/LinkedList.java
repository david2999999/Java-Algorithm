public class LinkedList<T> {
    private ListElement<T> list;

    public ListElement<T> insertInFront(int data) {
        ListElement<T> newElement = new ListElement<T>(data);
        list.setNext(newElement);
        list = newElement;
        return list;
    }
}