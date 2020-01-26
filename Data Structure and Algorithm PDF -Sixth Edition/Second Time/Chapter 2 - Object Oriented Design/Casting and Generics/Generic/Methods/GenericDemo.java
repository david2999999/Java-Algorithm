public class GenericDemo {
    public static <T> void reverse (T[] data) {
        int low = 0, high = data.length - 1;
        while (low < high) {
            T temp = data[low];
            data[low++] = data[high];
            data[high--] = temp;
        }
    }
}

// Note the use of the <T> modifier to declare the method to be generic, and the use
// of the type T within the method body, when declaring the local variable, temp.
// The method can be called using the syntax, GenericDemo.reverse(books), with
// type inference determining the generic type, assuming books is an array of some
// object type. (This generic method cannot be applied to primitive arrays, because
// autoboxing does not apply to entire arrays.)