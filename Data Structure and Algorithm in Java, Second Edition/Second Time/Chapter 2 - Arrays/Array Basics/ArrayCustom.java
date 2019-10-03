public class ArrayCustom {
    private int[] arr;
    private int currentSize;

    public ArrayCustom(int size) {
        this.arr = new int[size];
        this.currentSize = 0;
    }

    public void print() {
        for (int i = 0; i < currentSize; i++) {
            System.out.println(arr[i]);
        }
    }

    public boolean find(int value) {
        for (int num: arr) {
            if (value == num) return true;
        }

        return false;
    }

    public void insert(int value, int index) {
        if (currentSize == arr.length) throw new ArrayStoreException("The array is full");
        if (index < 0 || index > currentSize) throw new IndexOutOfBoundsException("Invalid Index");

        System.arraycopy(arr, index, arr, index + 1, currentSize - index);
        arr[index] = value;
        currentSize++;
    }

    public void add(int value) {
        if (currentSize == arr.length) throw new ArrayStoreException("Array is full");

        arr[currentSize++] = value;
    }

    public void remove(int index) {
        if (currentSize == 0) throw new IndexOutOfBoundsException("The array is empty.");
        if (index < 0 || index >= currentSize) throw new IndexOutOfBoundsException("Invalid index to delete element.");

        System.arraycopy(arr, index + 1, arr, index, currentSize - index - 1);
        currentSize--;
    }

    public static void main(String[] args) {
        ArrayCustom array = new ArrayCustom(10);

        for (int i = 0; i < 10; i++) {
            array.add(i);
        }

        array.print();
    }
}
