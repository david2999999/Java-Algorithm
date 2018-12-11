public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;
    
    public ArrayStack() {
        this(CAPACITY);
    }
    
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }
    
    public int size() {
        return t + 1;
    }
    
    public boolean isEmpty() {
        return t == -1;
    }
}