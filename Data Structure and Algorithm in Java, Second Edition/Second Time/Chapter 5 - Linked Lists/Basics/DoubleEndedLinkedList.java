public class DoubleEndedLinkedList {
    private Link first;
    private Link last;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        Link link = new Link(data);

        if (isEmpty()) {
            last = link;
        }

        link.next = first;
        first = link;
    }

    public void add(int data) {
        Link link = new Link(data);

        if (isEmpty()) {
            first = link;
        } else {
            last.next = link;
        }

        last = link;
    }

    public boolean deleteFirst() {
        if (isEmpty()) return false;

        if (first.next() == null) {
            last = null;
        }

        first = first.next();
        return true;
    }

    public void displayList() {
        Link current = head;

        while (current != null) {
            System.out.println("data = " + current.data);
            current = current.next;
        }
    }
}