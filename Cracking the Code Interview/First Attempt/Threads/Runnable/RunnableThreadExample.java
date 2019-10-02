package Threads.Runnable;

public class RunnableThreadExample implements Runnable {
    public int count = 0;

    @Override
    public void run() {
        System.out.println("Runnable Thread running");
        try {
            while (count < 5) {
                Thread.sleep(500);
                count++;
            }
        } catch (InterruptedException e) {
            System.out.println("Runnable Thread Interrupted");
        }

        System.out.println("Runnable Thread terminating");
    }
}
