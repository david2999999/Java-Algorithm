public class Portfolio<T> {
    private T[] data;

    public Portfolio(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }
}