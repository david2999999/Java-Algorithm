package Threads.Thread;

public class Main {
    public static void main(String[] args) {
        ThreadExample instance = new ThreadExample();
        instance.start();

        while (instance.count != 5) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException exc){
                exc.printStackTrace();
            }
        }
    }
}
