public class FindMToLastElement {
    public Element findMToLastElement(Element head, int m) {
        if (head == null) return null;

        Element current = head;
        for (int i = 0; i < m; i++) {
            if (current.next != null) {
                current = current.next;
            } else {
                return null;
            }
        }

        Element mBehind = head;

        while (current.next != null) {
            mBehind = mBehind.next;
            current = current.next;
        }

        return mBehind;
    }
}