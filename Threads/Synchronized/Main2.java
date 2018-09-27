package Threads.Synchronized;

public class Main2 {
    public static void main(String[] args) {
        MyObject obj = new MyObject();
        MyClass thread1 = new MyClass(obj, "1");
        MyClass thread2 = new MyClass(obj, "2");


        // same reference to obj. so only a single call to foo() is allowed
        thread1.start();
        thread2.start();
    }
}
