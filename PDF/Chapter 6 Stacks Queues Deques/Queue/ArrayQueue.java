public class ArrayQueue<E> implements Queue<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int f = 0;
    private int sz = 0;
    
    public ArrayQueue() { this(CAPACITY); }
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }
    
    public int size() {
        return sz;
    }
    
    public boolean isEmpty() {
        return sz == 0;
    }
}