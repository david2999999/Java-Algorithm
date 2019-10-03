package ThreadsAndLocks.DiningPhilosopher.Solution1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {
    private Lock lock;

    public ChopStick() {
        lock = new ReentrantLock();
    }

    public void pickUp() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }
}
