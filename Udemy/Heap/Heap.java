package Heap;

public class Heap {
    private int[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        }

        heap[size] = value;
        fixHeapAbove(size++);
    }

    private void fixHeapAbove(int index) {
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        heap[index] = newValue;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }
}
