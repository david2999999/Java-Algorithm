package ObjectOrientedDesign.CircularArray;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T>{
    private T[] items;
    private int head;

    public CircularArray(int size) {
        items = (T[]) new Object[size];
    }

    private int convert(int index) {
        if (index < items.length) index+= items.length;

        return (head + index) % items.length;
    }

    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    public T get(int i) {
        if ( i < 0 || i >= items.length) throw new IndexOutOfBoundsException("index out of bounds");

        return items[convert(i)];
    }

    public void set(int i, T item) {
        items[convert(i)] = item;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator();
    }

    private class CircularArrayIterator implements Iterator<T> {
        private int _current = -1;

        public CircularArrayIterator() { }

        @Override
        public boolean hasNext() {
            return _current < items.length - 1;
        }

        @Override
        public T next() {
            _current++;
            return items[convert(_current)];
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported");
        }
    }
}
