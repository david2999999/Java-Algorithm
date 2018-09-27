package Threads.Synchronized;

public class Main {
    public static void main(String[] args) {
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();

        MyClass thread1 = new MyClass(obj1, "1");
        MyClass thread2 = new MyClass(obj2, "2");

        // there are different references for myObject, so both threads can run MyObject.foo()
        thread1.start();
        thread2.start();
    }
}
