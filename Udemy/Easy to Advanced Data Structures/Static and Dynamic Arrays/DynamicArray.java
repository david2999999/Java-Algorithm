public class DynamicArray<T> implements Iterable<T> {
    private T[] arr;
    private int length = 0;
    private int capacity = 0;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }

        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public T set(int index, T element) {
        arr[index] = element;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }

        this.length = 0;
    }

    public void add(T element) {
        resize();
        arr[length++] = element;
    }

    public T removeAt(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        T data = arr[index];
        T[] newArray = (T[]) new Object[length - 1];
        for (int i = 0, j = 0; i < length; i++, j++) {
            if (i == index) {
                j--;
            } else {
                newArray[j] = arr[i];
            }
        }

        arr = newArray;
        capacity = --length;
        return data;
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(obj)) {
                removeAt(i);
                return true;
            }
        }

        return false;
    }

    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    private void resize() {
        if (length + 1 >= capacity) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }

            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < length; i++) {
                newArray[i] = arr[i];
            }

            arr = newArray;
        }
    }
}