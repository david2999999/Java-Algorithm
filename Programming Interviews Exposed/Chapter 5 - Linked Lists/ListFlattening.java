public class ListFlattening {
    public void flattenList(Element head, Element tail) {
        Element current = head;

        while (current != null) {
            if (current.child != null) {
                append(current.child, tail);
            }

            current = current.next;
        }
    }

    private void append(Element child, Element tail) {
        tail.next = child;
        child.prev = tail;

        while(child.next != null) {
            child = child.next;
        }

        tail = child;
    }
}