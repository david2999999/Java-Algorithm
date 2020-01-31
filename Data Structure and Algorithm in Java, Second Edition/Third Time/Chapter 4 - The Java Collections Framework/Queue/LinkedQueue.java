public class LinkedQueue<E> extends AbstractQueue<E> implements Queue<E> {
    private List<E> list = new LinkedList<E>();

    public Iterator<E> iterator() {
        return list.iterator();
    }

    public boolean offer(E e) {
        if (e == null) {
            return false;
        } else {
            list.add(e);
            return true;
        }
    }

    public E peek() {
        return list.get(0);
    }

    public E poll() {
        if (list.isEmpty()) return null;
        return list.remove(0);
    }

    public int size() {
        return list.size();
    }
}