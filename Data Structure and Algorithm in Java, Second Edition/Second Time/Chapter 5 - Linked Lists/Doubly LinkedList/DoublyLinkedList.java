public class DoublyLinkedList {
    private Link first;
    private Link last;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long data) {
        Link newLink = new Link(data);

        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }

        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long data) {
        Link newLink = new Link(data);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }

        last = newLink;
    }

    public Link deleteFirst() {
        if (isEmpty()) return null;

        Link temp = first;
        if (first.next = null) {
            last = null;
        } else {
            first.next.previous = null;
        }

        first = first.next;
        return temp;
    }

    public Link deleteLast() {
        if (isEmpty()) return null;

        Link temp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }

        last = last.previous;
        return temp;
    }

    public boolean insertAfter(long key, long data) {
        Link current = find(key);
        if (current == null) return false;

        Link newLink = new Link(data);
        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }

        newLink.previous = current;
        current.next = newLink;
        return true;
    }

    public Link deleteKey(long key) {
        Link current = find(key);
        if (current == null) return null;

        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }

        return current;
    }

    public Link find(long key) {
        if (isEmpty()) return null;

        Link current = first;
        while (current != null) {
            if (current.data == key) {
                return current;
            }
        }

        return null;
    }

    public void displayForward() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

    public void displayBackward() {
        Link current = last;

        while (current != null) {
            current.displayLink();
            current = current.last;
        }
    }
}