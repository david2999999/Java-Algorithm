package CodeLibrary;

public class LinkedListNodeString {
    public LinkedListNodeString next, prev, last;
    public int key;
    public String value;

    public LinkedListNodeString(int d, String value, LinkedListNodeString n, LinkedListNodeString p) {
        key = d;
        value = value;
        next = n;
        prev = p;
    }

    public LinkedListNodeString(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public LinkedListNodeString() {
    }

    public void setNext(LinkedListNodeString n) {
        next = n;
        if (this == last) {
            n = last;
        }

        if (n != null && n.prev != this) {
            n.setPrevious(this);
        }
    }

    public void setPrevious(LinkedListNodeString p) {
        prev = p;
        if (p != null && p.next != this) {
            p.setNext(this);
        }
    }

    public LinkedListNodeString clone() {
        LinkedListNodeString next2 = null;
        if (next != null) {
            next2 = next.clone();
        }

        LinkedListNodeString head2 = new LinkedListNodeString(key, value, next2, null);
        return head2;
    }

}
