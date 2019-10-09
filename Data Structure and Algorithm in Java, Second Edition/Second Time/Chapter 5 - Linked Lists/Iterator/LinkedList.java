public class LinkedList {
    private Link first;

    public ListIterator iterator() {
        return new ListIterator(this);
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        Link link = new Link(data);
        link.next = first;
        first = link;
    }

    public Link deleteFirst() {
        if (first == null) return;

        Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        Link current = head;

        while (current != null) {
            System.out.println("data = " + current.data);
            current = current.next;
        }
    }

    public boolean delete(int key) {
        if (isEmpty()) return false;

        if (first.data == key) {
            first = first.next;
            return true;
        }

        Link current = first;
        Link previous = first;

        while (current != null) {
            if (current.data == key) {
                previous.next = current.next;
                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }
}