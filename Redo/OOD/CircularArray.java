package Redo.OOD;

public class CircularArray<T> {
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

}
