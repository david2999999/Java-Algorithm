package Threads.Thread;

public class ThreadExample extends Thread {
    int count = 0;

    public void run() {
        System.out.println("Thread Starting");
        try {
            while (count < 5) {
                Thread.sleep(500);
                System.out.println("In thread, count is " + count);
                count++;
            }
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted");
        }
        System.out.println("Thread Terminating");
    }
}
