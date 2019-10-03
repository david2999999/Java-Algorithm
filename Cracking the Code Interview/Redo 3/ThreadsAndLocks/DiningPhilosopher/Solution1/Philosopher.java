package ThreadsAndLocks.DiningPhilosopher.Solution1;

public class Philosopher extends Thread {
    private int bites = 10;
    private ChopStick left, right;

    public Philosopher(ChopStick left, ChopStick right) {
        this.left = left;
        this.right = right;
    }

    public void eat() {
        pickUp();
        chew();
        putDown();
    }

    private void chew() { }

    public void putDown() {
        left.putDown();
        right.putDown();
    }

    public void pickUp() {
        left.pickUp();
        right.pickUp();
    }

    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }
}
