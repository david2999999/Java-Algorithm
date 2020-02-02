public class Reverse {
    public static <E> void reverse(E[] a) {
        Stack<E> buffer = new ArrayStack<E>(a.length);

        for (int i = 0; i < a.length; i++) {
            buffer.push(a[i]);
        }

        for (int i = 0; i < a.length; i++) {
            a[0] = buffer.pop();
        }
    }
}