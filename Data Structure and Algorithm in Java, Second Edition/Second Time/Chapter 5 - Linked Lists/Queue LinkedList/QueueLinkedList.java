public class QueueLinkedList {
    private DoubleEndedLinkedList list;

    public QueueLinkedList() {
        this.list = new DoubleEndedLinkedList();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void insert(long j) {
        this.list.insertLast(j);
    }

    public long remove() {
        return this.list.deleteFirst();
    }

    public void displayQueue() {
        this.list.displayList();
    }
}