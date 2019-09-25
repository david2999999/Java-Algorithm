public class LinkedList {
    private Element head;
    private Element tail;

    public boolean delete(Element e) {
        if (e == null) return false;

        if (head == e) {
            head = head.next;

            if (head == null) {
                tail = null;
            }

            return true;
        }

        Element current = head;

        while (current != null) {
            if (current.next == e) {
                current.next = e.next;

                if (current.next == null) {
                    tail = current;
                }
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public boolean insertAfter(Element e, int data) {
        Element newElement = new Element(data);

        if (e == null) {	// no such element in the list
            newElement.next = head;
            head = newElement;

            if (tail == null) {
                tail = newElement;
            }
        }

        Element current = head;

        while (current != null) {
            if (current == e) {
                newElement.next = current.next;
                current.next = newElement;

                if (newElement.next == null) {
                    tail = newElement;
                }

                return true;
            }

            current = current.next;
        }

        return false;
    }
}