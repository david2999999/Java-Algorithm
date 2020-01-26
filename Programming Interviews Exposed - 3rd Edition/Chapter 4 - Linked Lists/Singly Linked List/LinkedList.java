public class LinkedList<T> {
    private ListElement<T> head;

    public ListElement<T> insertInFront(T data) {
        ListElement<T> newElement = new ListElement<T>(data);
        head.setNext(newElement);
        head = newElement;
        return head;
    }

    public ListElement<T> find(T data) {
        ListElement<T> elem = head;

        while (elem != null && elem.value() != data) {
            elem = elem.next();
        }

        return elem;
    }
}