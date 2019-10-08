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

    public void displayList() {
        Link current = head;

        while (current != null) {
            System.out.println("data = " + current.data);
            current = current.next;
        }
    }
}