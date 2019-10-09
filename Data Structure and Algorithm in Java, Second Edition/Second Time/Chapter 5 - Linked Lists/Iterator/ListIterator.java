public class ListIterator {
    private Link current;
    private Link previous;
    private LinkedList list;

    public ListIterator(LinkedList list) {
        this.list = list;
        reset();
    }

    public void reset() {
        current = list.getFirst();
        previous = null;
    }

    public boolean atEnd() {
        return current.next == null;
    }

    public void nextLink() {
        previous = current;
        current = current.next;
    }

    public Link current() {
        return current;
    }

    public void insertAfter(long data) {
        Link newLink = new Link(data);

        if (list.isEmpty()) {
            list.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(long data) {
        Link newLink = new Link(data);

        if (previous == null) {
            newLink.next = list.getFirst();
            list.setFirst(newLink);
            reset();
        } else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public long deleteCurrent() {
        if (current == null) throw new InvalidOperationException();

        long value = current.data;
        if (previous == null) {
            list.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;

            if (atEnd()) {
                reset();
            } else {
                current = current.next;
            }
        }

        return value;
    }
}