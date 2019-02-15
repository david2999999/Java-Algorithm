public class TestFill {
    public static void main(String[] args) {
        Object[] a = new Object[4];
        Arrays.fill(a, new Date());
        ch02.ex02.DuplicatingArrays.print(a);
        Arrays.fill(a, 22);
        ch02.ex02.DuplicatingArrays.print(a);
        Arrays.fill(a, "Yo!");
        ch02.ex02.DuplicatingArrays.print(a);
    }
}