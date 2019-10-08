public class LinkedList {
    private Link first;

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
}