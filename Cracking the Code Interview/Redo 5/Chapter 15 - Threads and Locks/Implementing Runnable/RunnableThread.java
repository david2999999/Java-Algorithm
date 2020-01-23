public class RunnableThread implements Runnable {
    public int count = 0;

    public void run() {
        System.out.println("Runnable Thread starting");

        try {
            while (count < 5) {
                Thread.sleep(500);
                count++;
            } catch (InterruptedException e) {
                System.out.println("RunnableThread Interrupted");
            }

            System.out.println("Runnable thread terminating");
        }
    }
}