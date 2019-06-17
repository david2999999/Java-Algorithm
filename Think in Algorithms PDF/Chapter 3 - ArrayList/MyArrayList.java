public class MyArrayList implements List<E> {
    private E[] array;
    private int size;
    
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
    
    
}