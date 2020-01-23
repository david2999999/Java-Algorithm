public class RunnableThreadExample {
    public static void main(String[] args) {
        RunnableThread instance = new RunnableThread();
        Thread thread = new Thread(instance);
        thread.start();

        while (instance.count != 5) {
            try {
                Thread.sleep(250)
            } catch (InterrupedException e) {
                e.printStackTrace();
            }
        }
    }
}