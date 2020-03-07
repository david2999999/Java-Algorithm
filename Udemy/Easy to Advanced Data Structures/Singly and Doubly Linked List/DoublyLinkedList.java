public class DoublyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> {
        T data;
        Node<T> prev, next;

        public Node (T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public void clear() {
        Node<T> current = head;

        while (current != null) {
            Node<T> next = current.next;
            current.prev = current.next = null;
            current.data = null;
            current = next;
        }

        head = tail = current = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T element) {
        addLast(element);
    }

    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<T>(element, null, null);
        } else {
            head.prev = new Node<T>(element, null, head);
            head = head.prev;
        }

        size++;
    }

    public void addLast(T element) {
        if (isEmpty()) {
            head = tail = new Node<T>(element, null, null);
        } else {
            tail.next = new Node<T>(element, tail, null);
            tail = tail.next;
        }

        size++;
    }

    public T peekFirst() {
        if (isEmpty()) {
            return null;
        } else {
            return head.data;
        }
    }

    public T peekLast() {
        if (isEmpty()) {
            return null;
        } else {
            return tail.data;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T data = head.data;
        head = head.next;
        --size;

        if (isEmpty()) {
            tail = null;
        } else {
            head.prev = null;
        }

        return data;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T data = tail.data;
        tail = tail.prev;
        size--;

        if (isEmpty()) {
            head = null;
        } else {
            tail.next = null;
        }

        return data;
    }

    private T remove(Node<T> node) {
        if (node.prev == null) {
            return removeFirst();
        }

        if (node.next == null) {
            return removeLast();
        }

        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data;

        node.data = null;
        node = node.prev = node.next = null;

        --size;
        return data;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }

        Node<T> current;

        if (index < size / 2) {
            for (int i = 0; current = head; i != index; i++) {
                current = current.next;
            }
        } else {
            for (int i = size - 1, current = tail; i != index; i--) {
                current = current.prev;
            }
        }

        return remove(current);
    }

    public boolean remove(Object obj) {
        Node<T> current;

        if (obj == null) {
            for (current = head; current != null; current = current.next) {
                if (current.data == null) {
                    remove(current);
                    return true;
                }
            }
        } else {
            for (current = head; current != null; current = current.next) {
                if (obj.equals(current.data)) {
                    remove(current);
                    return true;
                }
            }
        }

        return false;
    }

    public int indexOf(Object obj) {
        int index = 0;
        Node<T> current;

        if (obj == null) {
            for (current = head; current != null; current = current.next, index++) {
                if (current.data == null) {
                    return index;
                }
            }
        } else {
            for (current = head; current != null; current = current.next, index++) {
                if (obj.equals(current.data)) {
                    return index;
                }
            }
        }

        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        }
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "DoublyLinkedList{" +
                "size=" + size +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}




























