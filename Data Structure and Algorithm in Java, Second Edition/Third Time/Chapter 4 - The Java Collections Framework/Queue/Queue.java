public interface Queue<E> extends Collection<E> {
    boolean offer(E o);

    E poll();

    E remove();

    E peek();

    E element();
}