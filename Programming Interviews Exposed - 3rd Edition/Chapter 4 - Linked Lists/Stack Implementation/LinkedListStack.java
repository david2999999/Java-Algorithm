public class LinkedListStack<E> implements Stack<E> {
    private static class LinkedListNode<E> {
        private E data;
        private LinkedListNode<E> next;

        public LinkedListNode(E data) {
            this.data = data;
        }

        public LinkedListNode(E data, LinkedListNode<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public LinkedListNode<E> getNext() {
            return next;
        }

        public void setNext(LinkedListNode<E> next) {
            this.next = next;
        }
    }

    private LinkedListNode<E> head;
    private int size = 0;

    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return head.getData();
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }

        E data = head.getData();
        head = head.getNext();
        size--;
        return data;
    }

    public void push(E value) {
        LinkedListNode<E> newest = new LinkedListNode<E>(value, head);
        head = newest;
        size++;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }
}