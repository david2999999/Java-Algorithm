public class UnflatteningList {
    public void unflattenList(Element start, Element tail) {
        traverseAndSeparate(start);

        Element current = start;
        while(current.next != null) {
            current = current.next;
        }

        tail = current;
    }

    private void traverseAndSeparate(Element start) {
        Element current = start;

        while(current != null) {
            if (current.child != null) {
                current.child.prev.next = null;
                current.child.prev = null;
                traverseAndSeparate(current.child);
            }

            current = current.next;
        }
    }
}