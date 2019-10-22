public class SortedLinkedList {
    private Link first;

    public boolean isEmpty() {
        return first == null;
    }

    public SortedLinkedList(Link[] linkArr) {
        first = null;
        for (int j = 0; j < linkArr.length; j++) {
            insert(linkArr[j]);
        }
    }

    public void insert(long key) {
        Link newLink = new Link(key);
        Link previous = null;
        Link current = first;

        while (current != null && key > current.data) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            first = newLink;
        } else {
            previous.next = newLink;
        }

        newLink.next = current;
    }

    public boolean remove() {
        if (isEmpty()) return false;

        first = first.next;
        return true;
    }
}