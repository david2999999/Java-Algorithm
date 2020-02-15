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

        ListElement<T> current = head;

        if (current.value() == data) {
            head = head.next();
            return true;
        }

        while (current.next() != null) {
            if (current.next().value() == data) {
                current.setNext(current.next().next());
                return true;
            }
        }

        return false;
    }

    private boolean isEmpty() {
        return head == null;
    }
}