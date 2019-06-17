public class MyArrayList implements List<E> {
    private E[] array;
    private int size;
    
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }
    
    public E set(int index, E element) {
        E old = get(index);
        array[index] = element;
        return old;
    }
    
    public E remove(int index) {
        E element = get(index);
        for (int i=index; i<size-1; i++) {
            array[i] = array[i+1];
        }
        size--;
        return element;
    }
    
    public boolean removeAll(Collection<?> collection) {
        boolean flag = true;
        for (Object obj: collection) {
            flag &= remove(obj);
        }
        return flag;
    }
    
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // add the element to get the resizing
        add(element);
        // shift the other elements
        for (int i=size-1; i>index; i--) {
            array[i] = array[i-1];
        }
        // put the new one in the right place
        array[index] = element;
    }
    
    public boolean add(E element) {
        if (size >= array.length) {
            // make a bigger array and copy over the elements
            E[] bigger = (E[]) new Object[array.length * 2];
            System.arraycopy(array, 0, bigger, 0, array.length);
            array = bigger;
        }
        array[size] = element;
        size++;
        return true;
    }
    
    public int indexOf(Object target) {
        for (int i = 0; i<size; i++) {
            if (equals(target, array[i])) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }
}

// In this method, the loop runs once for each element in collection. If collection
// contains m elements and the list we are removing from contains n elements,
// this method is in O(nm). If the size of collection can be considered con-
// stant, removeAll is linear with respect to n. But if the size of the collection
// is proportional to n, removeAll is quadratic. For example, if collection al-
// ways contains 100 or fewer elements, removeAll is linear. But if collection
// generally contains 1% of the elements in the list, removeAll is quadratic.