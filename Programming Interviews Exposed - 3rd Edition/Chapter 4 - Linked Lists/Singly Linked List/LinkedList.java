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

    public boolean delete(T data) {
        if (isEmpty()) return false;

        ListElement<T> elem = head;

        if (elem.value() == data) {
            head = head.next();
            return true;
        }

        while (elem.next() != null) {
            if (elem.next().value() == data) {
                elem.setNext(elem.next().next());
                return true;
            }
        }

        return false;
    }

    private boolean isEmpty() {
        return head == null;
    }
}