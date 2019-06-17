package ThreadsAndLocks.DiningPhilosopher.Solution2;

public class Philosopher extends Thread {
    private int bites = 10;
    private ChopStick left, right;

    public Philosopher(ChopStick left, ChopStick right) {
        this.left = left;
        this.right = right;
    }

    public void eat() {
        if (pickUp()){
            chew();
            putDown();
        }
    }

    private void chew() { }

    public void putDown() {
        left.putDown();
        right.putDown();
    }

    public boolean pickUp() {
        if (!left.pickUp()) {
            return false;
        }

        if (!right.pickUp()) {
            left.putDown();
            return false;
        }

        return true;
    }

    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }
}
