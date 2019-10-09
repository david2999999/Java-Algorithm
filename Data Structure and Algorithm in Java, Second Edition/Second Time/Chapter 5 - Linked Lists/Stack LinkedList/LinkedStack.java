public class LinkedStack {
    private LinkedList list;

    public LinkedStack() {
        this.list = new LinkedList();
    }

    public void push(long j) {
        this.list.insertFirst(j);
    }

    public long pop() {
        return this.list.deleteFirst();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void displayStack() {
        this.list.displayList();
    }
}