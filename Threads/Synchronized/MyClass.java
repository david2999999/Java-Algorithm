package Threads.Synchronized;

public class MyClass extends Thread {
    private String name;
    private MyObject object;

    public MyClass(MyObject obj, String name) {
        this.name = name;
        this.object = obj;
    }

    public void run() {
        object.foo(name);
    }
}
