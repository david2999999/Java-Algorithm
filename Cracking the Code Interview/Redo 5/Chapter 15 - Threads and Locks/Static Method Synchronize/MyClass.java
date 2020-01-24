public class MyClass extends Thread {
    public void run() {
        if (name.equals("!")) MyObject.foo(name);
        else if (name.equals("2")) MyObject.bar(name);
    }
}