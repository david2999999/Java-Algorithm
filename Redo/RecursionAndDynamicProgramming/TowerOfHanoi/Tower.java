package Redo.RecursionAndDynamicProgramming.TowerOfHanoi;

import java.util.Stack;

public class Tower {
    private Stack<Integer> disks;
    private int index;

    public Tower(int index) {
        this.disks = new Stack<>();
        this.index = index;
    }

    public void add(int i) {
        if (!disks.empty() && disks.peek() <= i) {
            System.out.println("Error placing disk " + i);
        } else {
            disks.push(i);
        }
    }

    public void moveTopTo(Tower t) {
        int top = disks.pop();
        t.add(top);
    }

    public int getIndex() {
        return index;
    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }
}
