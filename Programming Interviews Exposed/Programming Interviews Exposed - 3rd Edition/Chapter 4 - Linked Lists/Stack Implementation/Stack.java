public interface Stack<E> {
    E peek();
    E pop();
    void push(E value);
    boolean isEmpty();
    int size();
}