package ObjectOrientedDesign.CircularArray;

public class CircularArray<T> {
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
}
