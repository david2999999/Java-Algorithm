package Redo.OOD;

import java.util.Iterator;

public class CircularArray<T> implements Iterable<T>{
    private T[] items;
    private int head = 0;

    public CircularArray(int size) {
        this.items = (T[])new Object[size];
    }

    private int convert(int index) {
        if (index < 0) {
            index = index + items.length;
        }

        return (index + head) % items.length;
    }

    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    public T get(int i) {
        if (i < 0 || i >= items.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return items[convert(i)];
    }

    public void set(int i, T item) {
        this.items[convert(i)] = item;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator();
    }

    private class CircularArrayIterator implements Iterator<T> {
        private int current = -1;

        public CircularArrayIterator() { }

        @Override
        public boolean hasNext() {
            return current < items.length - 1;
        }

        @Override
        public T next() {
            return (T) items[convert(current)];
        }
    }
}
